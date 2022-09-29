import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static List<List<Integer>> graph;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        graph.add(null);
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        visited = new boolean[n + 1];
        count = 0;
        dfs(1);
        System.out.println(count - 1);
    }

    public static void dfs(int cur) {
        visited[cur] = true;
        count++;
        for (int next : graph.get(cur)) {
            if (visited[next]) {
                continue;
            }
            dfs(next);
        }
    }
}
