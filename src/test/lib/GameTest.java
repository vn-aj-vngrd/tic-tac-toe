package test.lib;

import main.lib.Game;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

public class GameTest {
    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void testInitializeBoard() {
        game = new Game();
        game.initializeBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals('-', game.getBoard()[i][j]);
            }
        }
    }

    @Test
    public void testChangePlayer() {
        game = new Game();
        assertEquals('X', game.getCurrentPlayerMark());
        game.changePlayer();
        assertEquals('O', game.getCurrentPlayerMark());
        game.changePlayer();
        assertEquals('X', game.getCurrentPlayerMark());
    }

    @Test
    public void testPlaceMark() {
        game = new Game();
        assertTrue(game.placeMark(0, 0));
        assertFalse(game.placeMark(0, 0));
        assertFalse(game.placeMark(3, 0));
        assertFalse(game.placeMark(0, 3));
    }

    @Test
    public void testPlaceMarkOutOfRange() {
        game = new Game();

        assertFalse(game.placeMark(-1, 0));
        assertFalse(game.placeMark(3, 0));
        assertFalse(game.placeMark(0, -1));
        assertFalse(game.placeMark(0, 3));
    }

    @Test
    public void testPlaceMarkAlreadyOccupied() {
        game = new Game();

        assertTrue(game.placeMark(0, 0));
        assertFalse(game.placeMark(0, 0));
    }
}
