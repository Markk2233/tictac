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

    public void makeMove(Scanner sc, int turn) {
        System.out.println("hodi eblan");
        int row = sc.nextInt();
        int col = sc.nextInt();
        if (row < 1 || row > 3 || col < 1 || col > 3) {
            System.out.println("loh");
        }
        putMoveIntoBoard(row, col, turn);
    }

    private void putMoveIntoBoard(int row, int col, int turn) {
        if (turn++ == 1) {
            board[row][col] = 'X';
        }
        else if (turn-- == 2) {
            board[row][col] = 'O';
        }
    }



    private void checkWin() {

    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TicTacToe game1 = new TicTacToe();

        while (!game1.isLoh) {


            game1.printBoard();

            game1.makeMove(scanner, 1);

        }


    }
}
