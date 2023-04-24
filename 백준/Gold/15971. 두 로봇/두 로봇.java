import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int a;
    static int b;
    static List<ArrayList<int[]>> adj;
    static int[] dist;
    static boolean[] visited;
    static int[] max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        adj.add(null);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        dist = new int[n + 1];
        visited = new boolean[n + 1];
        max = new int[n + 1];
//        if (a == b) {
//            System.out.println(0);
//            return;
//        }
        dfs(a, 0, 0);
        System.out.println(dist[b] - max[b]);
    }

    public static void dfs(int v, int d, int m) {
        visited[v] = true;
        dist[v] = d;
        max[v] = m;
        for (int[] e : adj.get(v)) {
            if (visited[e[0]]) {
                continue;
            }
            dfs(e[0], d + e[1], Math.max(m, e[1]));
        }
    }
}