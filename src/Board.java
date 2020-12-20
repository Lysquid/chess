import java.util.ArrayList;

import org.fusesource.jansi.Ansi.Color;

import Pieces.*;

public class Board {

    private Piece[][] grid;

    public Board() {
        grid = new Piece[8][8];

    }

    public void placePieces(Player[] player_list) {

        for (int i = 0; i < player_list.length; i++) {
            int y;
            Player player = player_list[i];
            Color color = player.getColor();
            Piece piece;

            ArrayList<Piece> pieces_row = new ArrayList<Piece>();
            pieces_row.add(new Rook(color));
            pieces_row.add(new Knight(color));
            pieces_row.add(new Bishop(color));
            pieces_row.add(new Queen(color));
            pieces_row.add(new King(color));
            pieces_row.add(new Bishop(color));
            pieces_row.add(new Knight(color));
            pieces_row.add(new Rook(color));

            y = (i == 0) ? 0 : 7;
            for (int x = 0; x < pieces_row.size(); x++) {
                piece = pieces_row.get(x);
                setPiece(piece, x, y);
                player.addPiece(piece);
            }

            y = (i == 0) ? 1 : 6;
            for (int x = 0; x < grid.length; x++) {
                piece = new Pawn(color);
                setPiece(piece, x, y);
                player.addPiece(piece);
            }
        }
    }

    public Piece getPiece(int x, int y) {
        return grid[x][y];
    }

    public Piece getPiece(int[] coords) {
        int x = coords[0];
        int y = coords[1];
        return getPiece(x, y);
    }

    public void setPiece(Piece piece, int x, int y) {
        grid[x][y] = piece;
        if (piece != null) {
            piece.setX(x);
            piece.setY(y);
        }
    }

    public void setPiece(Piece piece, int[] coords) {
        int x = coords[0];
        int y = coords[1];
        setPiece(piece, x, y);
    }

    public boolean is_free(int[] coords) {
        return (getPiece(coords) == null);
    }

    public void movePiece(Piece piece, int[] piece_coords, int[] target_coords) {
        setPiece(null, piece_coords);
        setPiece(piece, target_coords);
        piece.incMoves();
    }

}
