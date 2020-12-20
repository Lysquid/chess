package Display;

import static org.fusesource.jansi.Ansi.Color.BLACK;

import java.util.Scanner;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Color;
import org.fusesource.jansi.AnsiConsole;

import Game.Board;
import Game.Player;
import Pieces.Piece;
import Pieces.Piece.Error;

public class Display {

    final char corner = '■';
    final char move = '→';
    final char[] square = { '▐', '▌' };
    Scanner scanner;

    public void init() {
        AnsiConsole.systemInstall();
        println(Ansi.ansi().eraseScreen());
        scanner = new Scanner(System.in);
    }

    public void exit() {
        AnsiConsole.systemUninstall();
        scanner.close();
        System.exit(0);
    }

    public static void println(Ansi str) {
        AnsiConsole.out().println(str);
    }

    public static void print(Ansi str) {
        AnsiConsole.out().print(str);
    }

    public static void println(String str) {
        println(Ansi.ansi().a(str));
    }

    public Ansi renderPiece(Piece piece, int which_bg, int x) {
        Ansi str = new Ansi();
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

    public Ansi render_lost_pieces(Player player) {
        Ansi str = new Ansi();
        Piece[] lost_pieces = player.getLostPieces();
        str.a("\n ");
        if (lost_pieces.length > 0) {
            str.fgBright(player.getColor());
            for (Piece piece : lost_pieces) {
                str.a(piece.getSymbol());
            }
        }
        str.reset().a("\n");
        return str;
    }

    public void render(Board board, Player[] player_list) {
        Ansi str = new Ansi();
        Ansi line = new Ansi();

        str.a(render_lost_pieces(player_list[0]));

        line.fgBright(BLACK).a(corner + " ");
        for (int i = 0; i < 8; i++) {
            line.a((char) (97 + i) + " ");
        }
        line.a(corner + "\n");
        str.a("\n" + line);

        for (int y = 0; y < 8; y++) {
            str.a(8 - y);
            for (int x = 0; x < 8; x++) {
                Piece piece = board.getPiece(x, 7 - y);
                int which_bg = (x + (7 - y)) % 2;
                str.a(renderPiece(piece, which_bg, x));
            }
            str.reset().fgBright(BLACK).a(8 - y + "\n");
        }

        str.a(line).reset();
        str.a(render_lost_pieces(player_list[1]));

        println(str);
    }

    public String getInput(Player player) {
        Color color = player.getColor();
        print(Ansi.ansi().fgBright(color).a(player.getName() + " > ").reset());
        String input = scanner.nextLine();
        input = input.replaceAll("\\s+", "");
        return input;
    }

    public boolean is_resigning(String input) {
        return (input.equals("resign") || input.equals("exit"));
    }

    public void winMsg(Player player, int nbr_turns) {
        Color color = player.getColor();
        println(Ansi.ansi().fgBright(color).a("\n" + player.getName()).reset().a(" won after " + nbr_turns + " turns"));
    }

    public static char[] StringToChar(String str) {
        char[] chars = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        return chars;

    }

    public boolean is_valid(String input) {
        char[] chars = StringToChar(input);
        boolean valid = (chars.length == 4 || chars.length == 2);
        if (valid) {
            for (int i = 0; i < chars.length / 2; i++) {
                if (!((int) chars[i * 2] >= 97 && (int) chars[i * 2] <= 104)) {
                    valid = false;
                }
                if (!((int) chars[i * 2 + 1] >= 49 && (int) chars[i * 2 + 1] <= 56)) {
                    valid = false;
                }
            }
        }
        return valid;
    }

    public void errorMsg(Error error) {
        switch (error) {
            case INVALID_INPUT:
                println("Invalid input");
                break;
            case NO_PIECE:
                println("No piece to move");
                break;
            case OPPONENT_PIECE:
                println("Cannot move opponent piece");
                break;
            case ILLEGAL:
                println("Illegal move");
                break;
            case OBSTRUCTED:
                println("Cannot move because of obstruction");
                break;
            case OCCUPIED:
                println("Cannot move on already occupied tile");
                break;
            case NO_CAPTURE:
                println("Requirements for this move not met");
                break;
        }
    }

    public int[][] convertMoveInput(String input) {
        int[][] coords = new int[2][2];
        coords[0] = convertInput(input.substring(0, 2));
        coords[1] = convertInput(input.substring(2, 4));
        return coords;
    }

    public int[] convertInput(String input) {
        char[] chars = StringToChar(input);
        int[] coords = new int[2];
        coords[0] = (int) chars[0] - 97;
        coords[1] = (int) chars[1] - 49;
        return coords;
    }

    public String convertCoords(int[] coords) {
        String str = new String();
        str += (char) (97 + coords[0]);
        str += (char) (49 + coords[1]);
        return str;
    }

    public void logMsg(Piece piece, int[] piece_coords, int[] target_coords) {
        Ansi str = new Ansi();
        str.fgBright(piece.getColor()).a(piece.getName() + " ");
        str.reset().a(convertCoords(piece_coords) + " " + move + " ");
        str.a(convertCoords(target_coords));
        println(str);
    }

    public void logMsg(Piece piece, int[] piece_coords, Piece target_piece, int[] target_coords) {
        Ansi str = new Ansi();
        str.fgBright(piece.getColor()).a(piece.getName() + " ");
        str.reset().a(convertCoords(piece_coords) + " " + move + " ");
        str.fgBright(target_piece.getColor()).a(target_piece.getName() + " ");
        str.reset().a(convertCoords(target_coords));
        println(str);
    }

    public boolean is_stat(String input) {
        return (input.length() == 2);
    }

    public void piece_stat(Board board, int[] coords) {
        Ansi str = new Ansi();
        if (board.is_free(coords)) {
            str.a("No piece in " + convertCoords(coords));
        } else {
            Piece piece = board.getPiece(coords);
            Player player = piece.getPlayer();
            str.fgBright(player.getColor()).a(player.getName()).reset();
            str.a("'s " + piece.getName().toLowerCase() + " in " + convertCoords(coords) + " :\n");
            str.a("moved " + piece.nbr_moves + " times\n");
            str.a("captured " + piece.nbr_captures + " pieces\n");
        }
        print(str);
    }

}
