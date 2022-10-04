import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int count;
    static int innerCount;
    static List<Integer> result;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    innerCount = 0;
                    dfs(i, j);
                    result.add(innerCount);
                    count++;
                }
            }
        }
        Collections.sort(result);
        System.out.println(count);
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        innerCount++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }
            if (map[nx][ny] == 0 || visited[nx][ny]) {
                continue;
            }
            dfs(nx, ny);
        }
    }
}
