import static org.fusesource.jansi.Ansi.Color.BLACK;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import Pieces.Piece;

public class Display {

    final char[] files = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
    final char corner = '■';
    final char[] square = { '▐', '▌' };

    public void init() {
        AnsiConsole.systemInstall();
    }

    public void exit() {
        AnsiConsole.systemUninstall();
    }

    public static void print(Ansi str) {
        AnsiConsole.out().print(str);
    }

    public Ansi renderPiece(Piece piece, int which_bg, int x) {
        Ansi str = Ansi.ansi();
        switch (which_bg) {
            case 0:
                str.fgBright(BLACK).a(square[0]);
                str.bgBright(BLACK);
                break;
            case 1:
                if (x == 0) {
                    str.a((' '));
                }
                break;
        }

        if (piece != null) {
            str.fgBright(piece.getColor());
            str.a(piece.getSymbol());
        } else {
            str.a(' ');
        }

        str.reset();
        switch (which_bg) {
            case 0:
                str.fgBright(BLACK).a(square[1]);
                break;
            case 1:
                if (x == 7) {
                    str.a((' '));
                }
                break;
        }
        return str;

    }

    public void render(Board board) {
        Ansi str = Ansi.ansi().eraseScreen();
        str.fgBright(BLACK).a(corner + " ");
        for (char file : files) {
            str.a(file + " ");
        }
        str.a(corner + "\n");

        for (int y = 0; y < 8; y++) {
            str.a(8 - y);
            for (int x = 0; x < 8; x++) {
                Piece piece = board.getPiece(x, y);
                int which_bg = (x + y) % 2;
                str.a(renderPiece(piece, which_bg, x));
            }
            str.reset().fgBright(BLACK).a(8 - y + "\n");
        }

        str.fgBright(BLACK).a(corner + " ");
        for (char file : files) {
            str.a(file + " ");
        }
        str.a(corner + "\n");
        print(str);
    }
}
