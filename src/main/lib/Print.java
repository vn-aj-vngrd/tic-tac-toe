package main.lib;

public class Print {
    public void printHeader() {
        System.out.print("\033\143Tic-Tac-Toe Game\n\n");
    }

    public void printBoard(char[][] board) {
        System.out.println("    \033[1;37m1   2   3\033[0m");
        System.out.println("  \033[1;37m┌───┬───┬───┐\033[0m");
        for (int i = 0; i < board.length; i++) {
            System.out.print("\033[1;37m" + (1 + i) + " \033[0m" + "\033[1;37m│\033[0m");
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    System.out.print(" \033[1;32mX\033[0m \033[1;37m│\033[0m");
                } else if (board[i][j] == 'O') {
                    System.out.print(" \033[1;34mO\033[0m \033[1;37m│\033[0m");
                } else {
                    System.out.print("   \033[1;37m│\033[0m");
                }
            }
            System.out.println();
            if (i != board.length - 1) {
                System.out.println("  \033[1;37m├───┼───┼───┤\033[0m");
            }
        }
        System.out.println("  \033[1;37m└───┴───┴───┘\033[0m");
    }
}