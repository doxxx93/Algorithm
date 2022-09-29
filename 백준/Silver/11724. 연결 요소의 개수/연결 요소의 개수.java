import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int count;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

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
        // 정점 1부터 시작
        visited = new boolean[n + 1];
        count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int cur) {
        visited[cur] = true;
        for (int next : graph.get(cur)) {
            if (visited[next]) {
                continue;
            }
            dfs(next);
        }
    }
}
