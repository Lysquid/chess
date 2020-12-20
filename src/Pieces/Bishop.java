package Pieces;

import org.fusesource.jansi.Ansi.Color;

public class Bishop extends Piece {

    public Bishop(Color color) {
        super(color);
        name = "Bishop";
        symbol = 'b';
    }

    @Override
    public boolean legalMove() {
        // TODO Auto-generated method stub
        return false;
    }

}
