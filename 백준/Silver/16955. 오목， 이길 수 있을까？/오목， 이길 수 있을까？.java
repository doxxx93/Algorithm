import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[10][10];
        for (int i = 0; i < 10; i++) {
            board[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == '.') {
                    if (check(board, i, j)) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
    private static boolean check(char[][] arr, int r, int c) {
        int cnt = 0;
        for (int i = c - 1; i >= 0 && arr[r][i] == 'X'; i--) {
            cnt++;
        }
        for (int i = c + 1; i < 10 && arr[r][i] == 'X'; i++) {
            cnt++;
        }
        if (cnt >= 4) {
            return true;
        }

        cnt = 0;
        for (int i = r - 1; i >= 0 && arr[i][c] == 'X'; i--) {
            cnt++;
        }
        for (int i = r + 1; i < 10 && arr[i][c] == 'X'; i++) {
            cnt++;
        }
        if (cnt >= 4) {
            return true;
        }

        cnt = 0;
        for (int i = r + 1, j = c - 1; i < 10 && j >= 0 && arr[i][j] == 'X'; i++, j--) {
            cnt++;
        }
        for (int i = r - 1, j = c + 1; i >= 0 && j < 10 && arr[i][j] == 'X'; i--, j++) {
            cnt++;
        }
        if (cnt >= 4) {
            return true;
        }

        cnt = 0;
        for (int i = r + 1, j = c + 1; i < 10 && j < 10 && arr[i][j] == 'X'; i++, j++) {
            cnt++;
        }
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0 && arr[i][j] == 'X'; i--, j--) {
            cnt++;
        }
        return cnt >= 4;
    }
}
