package test;

import main.lib.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TicTacToeTest {

    @Test
    public void testTicTacToeInitialization() {
        Game game = new Game();
        Checker checker = new Checker();
        assertNotNull(game);
        assertNotNull(checker);
    }
}
