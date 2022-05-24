import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < board.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if (solve()) {
            printBoard();
        }
    }

    public static boolean checkRow(int row) {
        int[] check = new int[9];
        for (int i = 0; i < board[row].length; i++) {
            check[board[row][i] - 1]++;
        }
        for (int i = 0; i < check.length; i++) {
            if (check[i] != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkColumn(int col) {
        int[] check = new int[9];
        for (int i = 0; i < board.length; i++) {
            check[board[i][col] - 1]++;
        }
        for (int i = 0; i < check.length; i++) {
            if (check[i] != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkSquare(int row, int col) {
        int[] check = new int[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                check[board[row + i][col + j] - 1]++;
            }
        }
        for (int i = 0; i < check.length; i++) {
            if (check[i] != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkSudoku() {
        for (int i = 0; i < board.length; i++) {
            if (!checkRow(i) || !checkColumn(i)) {
                return false;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!checkSquare(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isValid(int row, int col, int num) {
        if (board[row][col] == 0) {
            for (int i = 0; i < board.length; i++) {
                if (board[row][i] == num) {
                    return false;
                }
            }
            for (int i = 0; i < board.length; i++) {
                if (board[i][col] == num) {
                    return false;
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[row - row % 3 + i][col - col % 3 + j] == num) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static boolean solve() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (isValid(i, j, k)) {
                            board[i][j] = k;
                            if (solve()) {
                                return true;
                            }
                            board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

}