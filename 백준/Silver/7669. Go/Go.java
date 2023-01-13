import java.util.*;

public class Main {

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int b = sc.nextInt();
            int w = sc.nextInt();
            int[][] board = new int[n][n];
            for (int i = 0; i < b; i++) {
                int r = sc.nextInt();
                int c = sc.nextInt();
                board[r - 1][c - 1] = 1;
            }
            for (int i = 0; i < w; i++) {
                int r = sc.nextInt();
                int c = sc.nextInt();
                board[r - 1][c - 1] = 2;
            }
            floodBoard(board);
            int bc = 0;
            int wc = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == 4) {
                        bc++;
                    }
                    if (board[i][j] == 8) {
                        wc++;
                    }
                }
            }
            if (bc == wc) {
                System.out.println("Draw");
            } else if (bc < wc) {
                System.out.println("White wins by " + (wc - bc));
            } else {
                System.out.println("Black wins by " + (bc - wc));
            }
        }
    }

    public static void floodBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if ((board[i][j] & 3) == 0) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    recFill(board, board[i][j] << 2, i + dr[k], j + dc[k]);
                }
            }
        }
    }

    public static void recFill(int[][] board, int val, int r, int c) {
        if (r < 0 || r >= board.length) {
            return;
        }
        if (c < 0 || c >= board.length) {
            return;
        }
        if ((board[r][c] & 3) > 0) {
            return;
        }
        if ((board[r][c] & val) > 0) {
            return;
        }
        board[r][c] |= val;
        for (int k = 0; k < 4; k++) {
            recFill(board, val, r + dr[k], c + dc[k]);
        }
    }
}