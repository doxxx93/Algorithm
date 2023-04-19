import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int a;
    static int b;
    static int m;
    static List<ArrayList<Integer>> adj;

    static int dist;
    static int ans;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        ans = Integer.MAX_VALUE;
        dist = 0;
        dfs(a, b);
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    public static void dfs(int cur, int tar) {
        if (cur == tar) {
            ans = Math.min(ans, dist);
            return;
        }
        visited[cur] = true;
        for (int nxt : adj.get(cur)) {
            if (visited[nxt]) {
                continue;
            }
            dist++;
            dfs(nxt, tar);
            dist--;
        }
    }
}