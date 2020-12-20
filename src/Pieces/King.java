package Pieces;

import org.fusesource.jansi.Ansi.Color;

public class King extends Piece {

    public King(Color color) {
        super(color);
        name = "King";
        symbol = 'K';
    }

    @Override
    public boolean legalMove() {
        // TODO Auto-generated method stub
        return true;
    }

}
