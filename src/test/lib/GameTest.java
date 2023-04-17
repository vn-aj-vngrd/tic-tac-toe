package test.lib;

import main.lib.Game;
import org.junit.Before;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

public class GameTest {
    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void testInitializeBoard() {
        game.initializeBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals('-', game.getBoard()[i][j]);
            }
        }
    }

    @Test
    public void testGetCurrentPlayerMark() {
        game.initializeBoard();
        assertEquals('X', game.getCurrentPlayerMark());
        game.changePlayer();
        assertEquals('O', game.getCurrentPlayerMark());
    }

    @Test
    public void testGetBoard() {
        game.initializeBoard();
        game.placeMark(0, 0);
        game.changePlayer();
        game.placeMark(1, 1);
        char[][] expectedBoard = { { 'X', '-', '-' }, { '-', 'O', '-' }, { '-', '-', '-' } };
        assertArrayEquals(expectedBoard, game.getBoard());
    }

    @Test
    public void testChangePlayer() {
        game.initializeBoard();
        assertEquals('X', game.getCurrentPlayerMark());
        game.changePlayer();
        assertEquals('O', game.getCurrentPlayerMark());
        game.changePlayer();
        assertEquals('X', game.getCurrentPlayerMark());
    }

    @Test
    public void testPlaceMark() {
        game.initializeBoard();
        assertTrue(game.placeMark(0, 0));
        assertFalse(game.placeMark(0, 0));
        assertFalse(game.placeMark(3, 0));
        assertFalse(game.placeMark(0, 3));
    }

    @Test
    public void testPlaceMarkOutOfRange() {
        game.initializeBoard();

        assertFalse(game.placeMark(-1, 0));
        assertFalse(game.placeMark(3, 0));
        assertFalse(game.placeMark(0, -1));
        assertFalse(game.placeMark(0, 3));
    }

    @Test
    public void testPlaceMarkAlreadyOccupied() {
        game.initializeBoard();

        assertTrue(game.placeMark(0, 0));
        assertFalse(game.placeMark(0, 0));
    }

    @Test
    public void testPrintHeader() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        game.printHeader();
        assertEquals("\033\143Tic-Tac-Toe Game\n\n", outputStream.toString());
    }

    @Test
    public void testPrintBoard() {
        game.initializeBoard();

        game.placeMark(0, 0);
        game.changePlayer();
        game.placeMark(1, 1);

        char board[][] = game.getBoard();
        assertTrue(board[0][0] == 'X' || board[1][1] == 'O' || board[2][2] == '-');

    }

}
