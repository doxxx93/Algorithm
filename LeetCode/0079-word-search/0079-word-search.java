class Solution {

    static int len;
    static int n;
    static int m;
    static char[] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public boolean exist(char[][] board, String word) {
        len = word.length();
        arr = word.toCharArray();
        n = board.length;
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == arr[0]) {
                    if (ex(i, j, 0, board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean ex(int x, int y, int index, char[][] board) {
        if (index == len) {
            return true;
        }

        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }

        if (board[x][y] != arr[index]) {
            return false;
        }

        if (board[x][y] == '0') {
            return false;
        }

        char tmp = board[x][y];
        board[x][y] = '0';

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (ex(nx, ny, index + 1, board)) {
                return true;
            }
        }

        board[x][y] = tmp;

        return false;
    }
}
