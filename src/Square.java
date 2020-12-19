import Pieces.Piece;

import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color.BLACK;
import static org.fusesource.jansi.Ansi.Color.WHITE;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Color;

public class Square {

    private Color color;
    private Piece piece;
    private int x;
    private int y;

    public Square(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
        piece = null;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Ansi render() {
        Ansi string = ansi();

        if (color == WHITE) {
            string.fgBright(BLACK).a('▐');
            string.bgBright(BLACK);
        } else {
            if (x == 0) {
                string.a((' '));
            }
        }

        if (piece != null) {
            string.a(piece.render());
        } else {
            string.a(' ');
        }

        string.reset();
        if (color == WHITE) {
            string.fgBright(BLACK).a('▌');
        } else {
            if (x == 7) {
                string.a((' '));
            }
        }
        return string;
    }

}
