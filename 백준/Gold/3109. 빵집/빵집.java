import java.io.*;
import java.util.*;

class Main {

    static final int MAX_ROWS = 10000;
    static final int MAX_COLS = 500;
    static final char BLOCK = 'x';
    static int numRows, numCols;
    static char[][] grid = new char[MAX_ROWS][MAX_COLS + 1];

    static int dfs(int row, int col) {
        if (row < 0 || row >= numRows) {
            return 0;
        }
        if (grid[row][col] == BLOCK) {
            return 0;
        }
        grid[row][col] = BLOCK;
        if (col == numCols - 1) {
            return 1;
        }

        if (dfs(row - 1, col + 1) != 0) {
            return 1;
        }
        if (dfs(row, col + 1) != 0) {
            return 1;
        }
        if (dfs(row + 1, col + 1) != 0) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        numRows = Integer.parseInt(st.nextToken());
        numCols = Integer.parseInt(st.nextToken());

        for (int r = 0; r < numRows; r++) {
            grid[r] = br.readLine().toCharArray();
        }

        int count = 0;
        for (int r = 0; r < numRows; ++r) {
            count += dfs(r, 0);
        }
        System.out.println(count);
    }
}