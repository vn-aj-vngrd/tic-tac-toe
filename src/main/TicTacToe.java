package main;

import java.util.Scanner;
import main.lib.*;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        Checker checker = new Checker();
        Print print = new Print();

        do {
            print.printHeader();
            print.printBoard(game.getBoard());

            int row, col;
            do {
                System.out.print(
                        "\nPlayer " + game.getCurrentPlayerMark()
                                + ", enter an empty row and column to place your mark (1-3)\n> ");
                row = scanner.nextInt() - 1;
                col = scanner.nextInt() - 1;
            } while (!game.placeMark(row, col));

            if (checker.checkForWin(game.getBoard()) || checker.checkBoardFull(game.getBoard())) {
                if (checker.checkForWin(game.getBoard())) {
                    System.out.println("\nPlayer " + game.getCurrentPlayerMark() + " wins!");
                } else {
                    System.out.println("\nIt's a tie!");
                }

                System.out.print("\nDo you want to play again? (y/n) \n> ");
                String answer = scanner.next();

                if (answer.equalsIgnoreCase("y")) {
                    game.initializeBoard();
                    game.changePlayer();
                } else {
                    System.out.print("\033\143");
                    System.out.println("Thanks for playing!");
                    break;
                }
            }

            game.changePlayer();

        } while (true);

        scanner.close();
    }
}
