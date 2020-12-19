package Pieces;

import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color.BLUE;
import static org.fusesource.jansi.Ansi.Color.RED;

import org.fusesource.jansi.Ansi;

public class Piece {

    protected char symbol;
    protected int player;

    public Piece(int player) {
        this.player = player;
    }

    public Ansi render() {
        return ansi().fgBright((player == 1) ? RED : BLUE).a(symbol).reset();
    }

}
