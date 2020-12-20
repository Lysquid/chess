package Pieces;

import Game.Board;
import Game.Player;

public class Knight extends Piece {

    public Knight(Player player) {
        super(player);
        name = "Knight";
        symbol = 'n';
    }

    @Override
    public Error legalMove(Board board, int[] coords) {
        // TODO Auto-generated method stub
        return null;
    }

}
