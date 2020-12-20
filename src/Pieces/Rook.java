package Pieces;

import org.fusesource.jansi.Ansi.Color;

public class Rook extends Piece {

    public Rook(Color color) {
        super(color);
        name = "Rook";
        symbol = 'r';
    }

    @Override
    public boolean legalMove() {
        // TODO Auto-generated method stub
        return true;
    }

}
