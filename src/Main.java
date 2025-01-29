
import java.util.Scanner;

class TicTacToe {

    char[][] board = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
    boolean isLoh = false;

    int turn = 1;

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int makeMove(Scanner sc, int turn) {
        System.out.println("hodi eblan");
        int col = sc.nextInt();
        int row = sc.nextInt();
        while (row < 1 || row > 3 || col < 1 || col > 3 || board[row-1][col-1] != '-') {
            System.out.println("loh, vvodi zanovo");
            row = sc.nextInt();
            col = sc.nextInt();
        }
        return putMoveIntoBoard(col, row, turn);
    }

    private int putMoveIntoBoard(int col, int row, int turn) {
        if (turn == 1 && board[row][col] == '-') {
            turn++;
            board[col-1][row-1] = 'X';
        }
        else if (turn == 2) {
            turn--;
            board[col-1][row-1] = '0';
        }
        return turn;
    }



    public boolean checkWin() {
        if ((board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') ||
                (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') ||
                (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') ||
                (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') ||
                (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') ||
                (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') ||
                (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') ||
                (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X'))
        {
            printBoard();
            System.out.println("First player wins...");
            return false;
        }
        if ((board[0][0] == '0' && board[0][1] == '0' && board[0][2] == '0') ||
                (board[1][0] == '0' && board[1][1] == '0' && board[1][2] == '0') ||
                (board[2][0] == '0' && board[2][1] == '0' && board[2][2] == '0') ||
                (board[0][0] == '0' && board[1][0] == '0' && board[2][0] == '0') ||
                (board[0][1] == '0' && board[1][1] == '0' && board[2][1] == '0') ||
                (board[0][2] == '0' && board[1][2] == '0' && board[2][2] == '0') ||
                (board[0][0] == '0' && board[1][1] == '0' && board[2][2] == '0') ||
                (board[0][2] == '0' && board[1][1] == '0' && board[2][0] == '0'))
        {
            printBoard();
            System.out.println("Second player wins...");
            return false;
        }

        return true;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TicTacToe game1 = new TicTacToe();
        int turn = 1;

        while (game1.checkWin()) {


            game1.printBoard();

            turn = game1.makeMove(scanner, turn);

        }


    }
}
