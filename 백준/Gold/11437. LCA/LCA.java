import java.io.*;
import java.util.*;

public class Main {

    // LCA
    static int n;
    static ArrayList<Integer>[] adj;

    static int[] parent;
    static int[] depth;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];
        parent = new int[n + 1];
        depth = new int[n + 1];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        parent[1] = 1;
        depth[1] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : adj[cur]) {
                if (parent[next] == 0) {
                    parent[next] = cur;
                    depth[next] = depth[cur] + 1;
                    q.add(next);
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(lca(u, v)).append("\n");
        }
        System.out.println(sb);
    }

    static int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int tmp = u;
            u = v;
            v = tmp;
        }
        while (depth[u] != depth[v]) {
            u = parent[u];
        }
        while (u != v) {
            u = parent[u];
            v = parent[v];
        }
        return u;
    }
}
