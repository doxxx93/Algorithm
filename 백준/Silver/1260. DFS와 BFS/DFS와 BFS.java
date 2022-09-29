import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static List<List<Integer>> graph;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        graph.add(null);
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }
        // 간선 M개
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(graph.get(i + 1));
        }
        // 정점 1부터 시작
        visited = new boolean[n + 1];
        sb = new StringBuilder();
        dfs(v);
        sb.append("\n");
        visited = new boolean[n + 1];
        bfs(v);
        System.out.println(sb);
    }
    public static void dfs(int cur) {
        visited[cur] = true;
        sb.append(cur).append(" ");
        for (int next : graph.get(cur)) {
            if (visited[next]) {
                continue;
            }
            dfs(next);
        }
    }

    public static void bfs(int cur) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(cur);
        visited[cur] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" ");
            for (int next : graph.get(now)) {
                if (visited[next]) {
                    continue;
                }
                queue.add(next);
                visited[next] = true;
            }
        }
    }
}
