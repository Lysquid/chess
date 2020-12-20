package Pieces;

import Game.Board;
import Game.Player;

public class Bishop extends Piece {

    public Bishop(Player player) {
        super(player);
        name = "Bishop";
        symbol = 'b';
    }

    @Override
    public Error legalMove(Board board, int[] coords) {
        // TODO Auto-generated method stub
        return null;
    }

}
