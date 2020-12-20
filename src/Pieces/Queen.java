package Pieces;

import Game.Board;
import Game.Player;

public class Queen extends Piece {

    public Queen(Player player) {
        super(player);
        name = "Queen";
        symbol = 'Q';
    }

    @Override
    public Error legalMove(Board board, int[] coords) {
        // TODO Auto-generated method stub
        return null;
    }

}
