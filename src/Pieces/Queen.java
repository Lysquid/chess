package Pieces;

import org.fusesource.jansi.Ansi.Color;

public class Queen extends Piece {

    public Queen(Color color) {
        super(color);
        name = "Queen";
        symbol = 'Q';
    }

    @Override
    public boolean legalMove() {
        // TODO Auto-generated method stub
        return true;
    }

}
