import org.fusesource.jansi.Ansi.Color;

/**
 * Chess
 */
public class Chess {

    public static void main(String[] args) {

        Player P1 = new Player("P1", Color.RED);
        Player P2 = new Player("P2", Color.BLUE);
        Player[] player_list = { P1, P2 };

        Board board = new Board();
        board.placePieces(player_list);

        Display display = new Display();
        display.init();
        display.render(board);
        display.exit();
    }
}