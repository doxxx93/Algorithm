import java.io. *;
import java.util.*;

public class Main {

    static char[][] map;
    static boolean[][] chk;
    static int n;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        chk = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                if (split[j].equals("B")) {
                    map[i][j] = 1;
                } else if (split[j].equals("G")) {
                    map[i][j] = 2;
                }
            }
        }
        int count = 0;
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    if (!chk[i][j] && map[i][j] == k) {
                        dfs(i, j, k);
                        count++;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 2) {
                    map[i][j] -= 2;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(chk[i], false);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    if (!chk[i][j] && map[i][j] == k) {
                        dfs(i, j, k);
                        count2++;
                    }
                }
            }
        }
        System.out.println(count + " " + count2);
    }

    private static void dfs(int x, int y, int c) {
        chk[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1) {
                continue;
            }
            if (chk[nx][ny]) {
                continue;
            }
            if (map[nx][ny] != c) {
                continue;
            }
            dfs(nx, ny, c);
        }
    }
}