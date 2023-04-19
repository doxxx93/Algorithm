import java.io.*;
import java.util.*;

public class Main {

    static int[] x, y;
    static int sz;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        x = new int[100];
        y = new int[100];
        sz = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            if (q == 1) {
                x[sz] = Integer.parseInt(st.nextToken());
                y[sz] = Integer.parseInt(st.nextToken());
                sz++;
            } else {
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                sb.append(bfs(u, v) + "\n");
            }
        }
        System.out.println(sb);
    }

    public static int bfs(int src, int dst) {
        boolean[] visited = new boolean[sz];
        visited[src] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(src);
        while (!q.isEmpty()) {
            int u = q.poll();
            if (u == dst) {
                return 1;
            }
            for (int v = 0; v < sz; v++) {
                if (!visited[v] && inRange(v, u)) {
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
        return 0;
    }

    public static boolean inRange(int a, int b) {
        return (x[a] < x[b] && x[b] < y[a]) || (x[a] < y[b] && y[b] < y[a]);
    }
}