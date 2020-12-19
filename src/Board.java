import Pieces.*;

import static org.fusesource.jansi.Ansi.Color.*;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Color;

public class Board {

    private Square[][] grid;

    public Board() {
        grid = new Square[8][8];
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Color color = ((x + y) % 2 == 0) ? WHITE : BLACK;
                grid[y][x] = new Square(color, x, y);
            }
        }
        grid[1][0].setPiece(new Pawn(1));
        grid[1][1].setPiece(new Pawn(1));
        grid[6][0].setPiece(new Pawn(2));
        grid[6][1].setPiece(new Pawn(2));
    }

    public Ansi render() {
        Ansi string = Ansi.ansi().eraseScreen();
        Square square;
        string.fgBright(BLACK).a("  a b c d e f g h  \n");

        for (int y = 0; y < 8; y++) {
            string.a(8 - y);
            for (int x = 0; x < 8; x++) {
                square = grid[y][x];
                string.a(square.render());
            }
            string.reset().fgBright(BLACK).a(8 - y + "\n");
        }
        string.fgBright(BLACK).a("  a b c d e f g h  \n");
        return string;

    }
}
