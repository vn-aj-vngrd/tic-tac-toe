package main.lib;

public class Checker {
    public boolean checkBoardFull(char[][] board) {
        boolean isFull = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    isFull = false;
                }
            }
        }

        return isFull;
    }
    
    public boolean checkForWin(char[][] board) {
        return (checkRowsForWin(board) || checkColumnsForWin(board) || checkDiagonalsForWin(board));
    }

    public boolean checkRowsForWin(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }

        return false;
    }

    public boolean checkColumnsForWin(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }

        return false;
    }

    public boolean checkDiagonalsForWin(char[][] board) {
        return (checkRowCol(board[0][0], board[1][1], board[2][2])
                || checkRowCol(board[0][2], board[1][1], board[2][0]));
    }

    public boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }
}
