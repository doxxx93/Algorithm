import java.io.*;
import java.util.*;

public class Main {

    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};
    static int r;
    static int c;

    static char[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[26];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited[map[0][0] - 'A'] = true;

        System.out.println(dfs(0, 0, 1));
    }

    public static int dfs(int x, int y, int cnt) {
        int max = cnt;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (inRange(nx, ny) && !visited[map[nx][ny] - 'A']) {
                visited[map[nx][ny] - 'A'] = true;
                max = Math.max(max, dfs(nx, ny, cnt + 1));
                visited[map[nx][ny] - 'A'] = false;
            }
        }
        return max;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}