package Pieces;

import Game.Board;
import Game.Player;

public class Rook extends Piece {

    public Rook(Player player) {
        super(player);
        name = "Rook";
        symbol = 'r';
    }

    @Override
    public Error legalMove(Board board, int[] coords) {
        // TODO Auto-generated method stub
        return null;
    }

}
