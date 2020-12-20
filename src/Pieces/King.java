package Pieces;

import Game.Board;
import Game.Player;

public class King extends Piece {

    public King(Player player) {
        super(player);
        name = "King";
        symbol = 'K';
    }

    @Override
    public Error legalMove(Board board, int[] coords) {
        // TODO Auto-generated method stub
        return null;
    }

}
