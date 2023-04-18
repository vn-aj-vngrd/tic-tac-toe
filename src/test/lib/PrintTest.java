package test.lib;

import main.lib.Print;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

public class PrintTest {

    private Print print;

    @Before
    public void setUp() throws Exception {
        print = new Print();
    }

    @Test
    public void testPrintHeader() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        print.printHeader();
        assertEquals("\033\143Tic-Tac-Toe Game\n\n", outputStream.toString());
    }

    @Test
    public void testPrintBoard() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        char[][] board = { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
        print.printBoard(board);
        String expectedOutput = "    \033[1;37m1   2   3\033[0m\n  \033[1;37m┌───┬───┬───┐\033[0m\n\033[1;37m1 \033[0m\033[1;37m│\033[0m   \033[1;37m│\033[0m   \033[1;37m│\033[0m   \033[1;37m│\033[0m\n  \033[1;37m├───┼───┼───┤\033[0m\n\033[1;37m2 \033[0m\033[1;37m│\033[0m   \033[1;37m│\033[0m   \033[1;37m│\033[0m   \033[1;37m│\033[0m\n  \033[1;37m├───┼───┼───┤\033[0m\n\033[1;37m3 \033[0m\033[1;37m│\033[0m   \033[1;37m│\033[0m   \033[1;37m│\033[0m   \033[1;37m│\033[0m\n  \033[1;37m└───┴───┴───┘\033[0m\n";

        assertEquals(expectedOutput, outContent.toString());
    }
}
