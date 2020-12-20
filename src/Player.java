import java.util.ArrayList;

import org.fusesource.jansi.Ansi.Color;

import Pieces.Piece;

public class Player {

    final Color color;
    final String name;
    ArrayList<Piece> alive_pieces = new ArrayList<Piece>();
    ArrayList<Piece> lost_pieces = new ArrayList<Piece>();

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void addPiece(Piece piece) {
        alive_pieces.add(piece);
    }

}
