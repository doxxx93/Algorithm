import java.io.*;
import java.util.*;

public class Main {

    static int y;
    static int x;
    static int k;
    static boolean[][] map;
    static boolean[][] visited;
    static final int[] dy = {0, -1, 0, 1};
    static final int[] dx = {-1, 0, 1, 0};

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new boolean[x][y];
            visited = new boolean[x][y];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[b][a] = true;
            }
            int cnt = 0;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (!visited[i][j] && map[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int i, int j) {
        visited[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int ny = i + dy[d];
            int nx = j + dx[d];
            if (ny < 0 || nx < 0 || ny >= x || nx >= y) {
                continue;
            }
            if (!visited[ny][nx] && map[ny][nx]) {
                dfs(ny, nx);
            }
        }
    }
}