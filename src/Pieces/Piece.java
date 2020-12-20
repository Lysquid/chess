package Pieces;

import org.fusesource.jansi.Ansi.Color;

enum MoveErrors {
    ILLEGAL, OCCUPIED, OBSTRUCTED, NO_CAPTURE
}

public abstract class Piece {

    private Color color;
    protected char symbol;
    protected String name;

    private int nbr_moves;
    private int x;
    private int y;

    public Piece(Color color) {
        this.color = color;
        nbr_moves = 0;
    }

    public Color getColor() {
        return color;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public abstract boolean legalMove();

    public void incMoves() {
        nbr_moves++;
    }

    public int getNbrMoves() {
        return nbr_moves;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getCoords() {
        int[] coords = { x, y };
        return coords;
    }

}
