import org.fusesource.jansi.AnsiConsole;

/**
 * Chess
 */
public class Chess {

    public static void main(String[] args) {

        AnsiConsole.systemInstall();
        // Ansi str =
        // ansi().eraseScreen().fg(RED).a(ansi().fg(BLUE).a("8")).fg(GREEN).a("
        // World").reset();
        // System.out.println(str);

        Board board = new Board();
        System.out.print(board.render());

        AnsiConsole.systemUninstall();

    }
}