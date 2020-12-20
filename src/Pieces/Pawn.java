package Pieces;

import org.fusesource.jansi.Ansi.Color;

public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);
        name = "Pawn";
        symbol = 'p';
    }

    @Override
    public boolean legalMove() {
        // TODO Auto-generated method stub
        return true;
    }

}
