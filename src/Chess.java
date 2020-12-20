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

        int nbr_turns = 0;
        Player active_player;
        Player inactive_player;
        Piece piece;

        display.render(board);
        display.exit();
    }
}