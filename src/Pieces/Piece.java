package Pieces;

import org.fusesource.jansi.Ansi.Color;

public class Piece {

    private Color color;
    protected char symbol;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public char getSymbol() {
        return symbol;
    }

}
