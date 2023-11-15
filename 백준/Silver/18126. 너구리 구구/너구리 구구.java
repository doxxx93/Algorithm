import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<long[]>> adj = new ArrayList<>();
    static boolean[] visited;
    static long maxDistance = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            adj.get(a).add(new long[]{b, c});
            adj.get(b).add(new long[]{a, c});
        }
        visited = new boolean[n + 1];
        dfs(1, 0L);
        System.out.println(maxDistance);
    }

    static void dfs(int node, long distance) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        maxDistance = Math.max(maxDistance, distance);

        for (long[] i : adj.get(node)) {
            dfs((int)i[0], distance + i[1]);
        }
    }
}