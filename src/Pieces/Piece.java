package Pieces;

import org.fusesource.jansi.Ansi.Color;

import Game.Board;
import Game.Player;

public abstract class Piece {

    public enum Error {
        INVALID_INPUT, NO_PIECE, OPPONENT_PIECE, ILLEGAL, OCCUPIED, OBSTRUCTED, NO_CAPTURE
    }

    protected char symbol;
    protected String name;
    protected Player player;

    public int nbr_moves;
    public int nbr_captures;
    private int x;
    private int y;

    public Piece(Player player) {
        this.player = player;
        nbr_moves = 0;
    }

    public Color getColor() {
        return player.getColor();
    }

    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public abstract Error legalMove(Board board, int[] coords);

    public void incMoves() {
        nbr_moves++;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getCoords() {
        int[] coords = { x, y };
        return coords;
    }

    public boolean belongs_to(Player player) {
        return (this.player == player);
    }

    public Player getPlayer() {
        return player;
    }

}
