import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dfs(0, 0);
        System.out.println(min);
    }

    public static void dfs(int index, int depth) {
        if (depth == n / 2) {
            diff();
            return;
        }

        for(int i = index; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    public static void diff() {
        int start = 0;
        int link = 0;

        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(visited[i] && visited[j]) {
                    start += map[i][j];
                    start += map[j][i];
                } else if(!visited[i] && !visited[j]) {
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }

        int res = Math.abs(start - link);
        if(res == 0) {
            System.out.println(res);
            System.exit(0);
        }
        min = Math.min(min, res);
    }
}