import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> graph;
    static boolean[] visited;
    static int distance;

    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        graph.add(null);
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        visited = new boolean[n + 1];
        distance = 0;
        result = new ArrayList<>();
        dfs(a, b);
        if (result.size() == 0) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            System.out.println(result.get(0));
        }
    }

    public static void dfs(int curr, int target) {
        if (curr == target) {
            result.add(distance);
            return;
        }
        visited[curr] = true;
        for (int next : graph.get(curr)) {
            if (visited[next]) {
                continue;
            }
            distance++;
            dfs(next, target);
            distance--;
        }
    }
}
