import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static int[][] temp;
    static final int EMPTY = 0;
    static final int WALL = 1;
    static final int VIRUS = 2;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(max);
    }

    private static void dfs(int count) {
        if (count == 3) {
            for (int i = 0; i < n; i++) {
                if (m >= 0)
                    System.arraycopy(map[i], 0, temp[i], 0, m);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (temp[i][j] == VIRUS) {
                        spread(i, j);
                    }
                }
            }
            max = Math.max(max, getSafeArea());
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == EMPTY) {
                    map[i][j] = WALL;
                    dfs(count + 1);
                    map[i][j] = EMPTY;
                }
            }
        }
    }

    private static int getSafeArea() {
        return Arrays.stream(temp).mapToInt(row -> (int) Arrays.stream(row).filter(i -> i == EMPTY).count()).sum();
    }

    private static void spread(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (temp[nx][ny] == EMPTY) {
                    temp[nx][ny] = VIRUS;
                    spread(nx, ny);
                }
            }
        }
    }
}
