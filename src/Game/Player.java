package Game;

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

    public boolean in_checkmate() {
        return false;
    }

    public String getName() {
        return name;
    }

    public void losePiece(Piece target_piece) {
        alive_pieces.remove(target_piece);
        lost_pieces.add(target_piece);
    }

    public Piece[] getLostPieces() {
        return lost_pieces.toArray(new Piece[lost_pieces.size()]);
    }

}
