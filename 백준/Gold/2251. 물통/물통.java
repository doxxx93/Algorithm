import java.io.*;
import java.util.*;

public class Main {

    static int[] limit;
    static boolean[][] visited;
    static Set<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        limit = new int[3];
        for (int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }
        result = new TreeSet<>();
        visited = new boolean[201][201];
        dfs(0, 0, limit[2]);
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    public static void dfs(int a, int b, int c) {
        if (visited[a][b]) {
            return;
        }
        visited[a][b] = true;
        if (a == 0) {
            result.add(c);
        }
        // a -> b
        if (a + b > limit[1]) {
            dfs(a + b - limit[1], limit[1], c);
        } else {
            dfs(0, a + b, c);
        }
        // a -> c
        if (a + c > limit[2]) {
            dfs(a + c - limit[2], b, limit[2]);
        } else {
            dfs(0, b, a + c);
        }
        // b -> a
        if (a + b > limit[0]) {
            dfs(limit[0], a + b - limit[0], c);
        } else {
            dfs(a + b, 0, c);
        }
        // b -> c
        if (b + c > limit[2]) {
            dfs(a, b + c - limit[2], limit[2]);
        } else {
            dfs(a, 0, b + c);
        }
        // c -> a
        if (a + c > limit[0]) {
            dfs(limit[0], b, a + c - limit[0]);
        } else {
            dfs(a + c, b, 0);
        }
        // c -> b
        if (b + c > limit[1]) {
            dfs(a, limit[1], b + c - limit[1]);
        } else {
            dfs(a, b + c, 0);
        }
    }
}
