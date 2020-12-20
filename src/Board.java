import Pieces.Pawn;
import Pieces.Piece;

public class Board {

    private Piece[][] grid;

    public Board() {
        grid = new Piece[8][8];

    }

    public void placePieces(Player[] player_list) {
        setPiece(new Pawn(player_list[0].getColor()), 0, 1);
        setPiece(new Pawn(player_list[0].getColor()), 1, 1);
        setPiece(new Pawn(player_list[1].getColor()), 0, 6);
        setPiece(new Pawn(player_list[1].getColor()), 1, 6);
    }

    public Piece getPiece(int x, int y) {
        return grid[x][y];
    }

    public Piece getPiece(int[] coords) {
        int x = coords[0];
        int y = coords[0];
        return getPiece(x, y);
    }

    public void setPiece(Piece piece, int x, int y) {
        grid[x][y] = piece;
    }

    public void setPiece(Piece piece, int[] coords) {
        int x = coords[0];
        int y = coords[0];
        setPiece(piece, x, y);
    }

}
