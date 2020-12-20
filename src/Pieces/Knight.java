package Pieces;

import org.fusesource.jansi.Ansi.Color;

public class Knight extends Piece {

    public Knight(Color color) {
        super(color);
        name = "Knight";
        symbol = 'n';
    }

    @Override
    public boolean legalMove() {
        // TODO Auto-generated method stub
        return true;
    }

}
