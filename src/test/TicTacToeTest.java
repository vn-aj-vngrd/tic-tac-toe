package test;

import main.lib.*;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

public class TicTacToeTest {
    private Game game;
    private Checker checker;

    @Before
    public void setUp() throws Exception {
        game = new Game();
        checker = new Checker();
    }

    @Test
    public void testTicTacToeInitialization() {
        game = new Game();
        checker = new Checker();
        assertNotNull(game);
        assertNotNull(checker);
    }

    @Test
    public void testWherePlayerXWins() {
        game.initializeBoard();
        // Simulate a game where player X wins
        game.placeMark(0, 0);
        game.changePlayer();

        game.placeMark(1, 0);
        game.changePlayer();

        game.placeMark(0, 1);
        game.changePlayer();

        game.placeMark(1, 1);
        game.changePlayer();

        game.placeMark(0, 2);
        game.changePlayer();

        assertTrue(checker.checkForWin(game.getBoard()));
        assertEquals('O', game.getCurrentPlayerMark());
    }

    @Test
    public void testWherePlayerYWins() {
        game.initializeBoard();
        // Simulate a game where player X wins
        game.placeMark(0, 0);
        game.changePlayer();

        game.placeMark(1, 0);
        game.changePlayer();

        game.placeMark(0, 1);
        game.changePlayer();

        game.placeMark(1, 1);
        game.changePlayer();

        game.placeMark(2, 1);
        game.changePlayer();

        game.placeMark(1, 2);
        game.changePlayer();

        assertTrue(checker.checkForWin(game.getBoard()));
        assertEquals('X', game.getCurrentPlayerMark());
    }

    @Test
    public void testWhereGameIsTied() {
        game.initializeBoard();
        // Simulate a game where it's a tie
        game.placeMark(0, 0);
        game.changePlayer();

        game.placeMark(0, 1);
        game.changePlayer();

        game.placeMark(0, 2);
        game.changePlayer();

        game.placeMark(1, 1);
        game.changePlayer();

        game.placeMark(1, 0);
        game.changePlayer();

        game.placeMark(2, 0);
        game.changePlayer();

        game.placeMark(1, 2);
        game.changePlayer();

        game.placeMark(2, 1);
        game.changePlayer();

        game.placeMark(2, 2);
        game.changePlayer();

        assertTrue(checker.checkBoardFull(game.getBoard()));
    }
}
