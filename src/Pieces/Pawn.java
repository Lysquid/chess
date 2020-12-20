package Pieces;

import Game.Board;
import Game.Player;

public class Pawn extends Piece {

    public Pawn(Player player) {
        super(player);
        name = "Pawn";
        symbol = 'p';
    }

    @Override
    public Error legalMove(Board board, int[] coords) {
        // TODO Auto-generated method stub
        return null;
    }

}
