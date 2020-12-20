import org.fusesource.jansi.Ansi.Color;

import Pieces.Piece;

/**
 * Chess
 */
public class Chess {

    public static void main(String[] args) {

        Display display = new Display();
        display.init();

        Player P1 = new Player("P1", Color.RED);
        Player P2 = new Player("P2", Color.BLUE);
        Player[] player_list = { P1, P2 };

        Board board = new Board();
        board.placePieces(player_list);

        boolean game = true;
        boolean checkmate = false;
        boolean stalemate = false;
        int nbr_turns = 0;
        Player active_player;
        Player inactive_player;

        do {

            active_player = player_list[nbr_turns % 2];
            inactive_player = player_list[(nbr_turns + 1) % 2];
            boolean valid_move = false;

            int[][] move_coords;
            int[] piece_coords;
            int[] target_coords;

            do {
                display.render(board, player_list);

                String input = display.getInput(active_player);
                if (display.is_resigning(input)) {
                    active_player = inactive_player;
                    game = false;
                } else if (!display.is_valid(input)) {
                    display.errorMsg(Errors.INVALID_INPUT);
                } else {
                    move_coords = display.convertInput(input);

                    piece_coords = move_coords[0];
                    target_coords = move_coords[1];
                    if (board.is_free(piece_coords)) {
                        display.errorMsg(Errors.NO_PIECE);
                    } else {
                        Piece piece = board.getPiece(piece_coords);
                        Piece target_piece = board.getPiece(target_coords);
                        if (!active_player.piece_belongs(piece)) {
                            display.errorMsg(Errors.OPPONENT_PIECE);
                        } else if (piece.legalMove()) {

                            valid_move = true;

                            if (board.is_free(target_coords)) {
                                display.logMsg(piece, piece_coords, target_coords);
                            } else {
                                inactive_player.losePiece(target_piece);
                                display.logMsg(piece, piece_coords, target_piece, target_coords);
                            }
                            board.movePiece(piece, piece_coords, target_coords);

                        }
                    }
                }
            } while (game && !valid_move);

            checkmate = inactive_player.in_checkmate();
            nbr_turns++;

        } while (game && !checkmate && !stalemate);

        display.winMsg(active_player, nbr_turns);
        display.exit();
    }
}