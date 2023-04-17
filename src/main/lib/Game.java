package main.lib;

public class Game {
    private char[][] board;
    private char currentPlayerMark;

    public Game() {
        board = new char[3][3];
        currentPlayerMark = 'X';
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public char getCurrentPlayerMark() {
        return currentPlayerMark;
    }

    public char[][] getBoard() {
        return board;
    }

    public boolean placeMark(int row, int col) {
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col] == '-') {
                    board[row][col] = currentPlayerMark;
                    return true;
                }
            }
        }

        return false;
    }

    public void changePlayer() {
        if (currentPlayerMark == 'X') {
            currentPlayerMark = 'O';
        } else {
            currentPlayerMark = 'X';
        }
    }

    public void printHeader() {
        System.out.print("\033\143Tic-Tac-Toe Game\n\n");
    }

    public void printBoard() {
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
