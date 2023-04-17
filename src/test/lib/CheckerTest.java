package test.lib;

import main.lib.Checker;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

public class CheckerTest {
    private Checker checker;

    @Before
    public void setUp() throws Exception {
        checker = new Checker();
    }

    @Test
    public void testCheckBoardFull() {
        char[][] board = { { 'X', 'O', 'X' }, { 'X', 'O', 'O' }, { 'O', 'X', 'X' } };
        assertEquals(true, checker.checkBoardFull(board));
    }

    @Test
    public void testCheckForWin() {
        char[][] board = { { 'X', 'O', 'X' }, { 'O', 'O', 'O' }, { 'X', 'X', 'O' } };
        assertEquals(true, checker.checkForWin(board));
    }

    @Test
    public void testCheckRowsForWin() {
        char[][] board = { { 'X', 'X', 'X' }, { 'O', 'O', '-' }, { '-', '-', '-' } };
        assertEquals(true, checker.checkRowsForWin(board));
    }

    @Test
    public void testCheckColumnsForWin() {
        char[][] board = { { 'X', 'O', 'X' }, { 'X', 'O', 'O' }, { 'X', 'X', 'O' } };
        assertEquals(true, checker.checkColumnsForWin(board));
    }

    @Test
    public void testCheckDiagonalsForWin() {
        char[][] board = { { 'X', 'O', 'X' }, { '-', 'X', '-' }, { 'O', 'O', 'X' } };
        assertEquals(true, checker.checkDiagonalsForWin(board));
    }

    @Test
    public void testCheckRowCol() {
        char c1 = 'X', c2 = 'O', c3 = 'X';
        assertEquals(false, checker.checkRowCol(c1, c2, c3));
    }
}