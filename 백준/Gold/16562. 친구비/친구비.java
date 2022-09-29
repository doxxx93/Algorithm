import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> graph;
    static boolean[] visited;
    static long[] fee;
    static int n;

    static long sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        fee = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            fee[i] = Long.parseLong(st.nextToken());
        }
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
        long answer = 0;
        for (int i = 1; i <= n; i++) {
            sum = Integer.MAX_VALUE;
            if (!visited[i]) {
                dfs(i);
                answer += sum;
            }
        }
        if (answer <= k) {
            System.out.println(answer);
        } else {
            System.out.println("Oh no");
        }
    }
    public static void dfs(int cur) {
        visited[cur] = true;
        sum = Math.min(sum, fee[cur]);
        for (int next : graph.get(cur)) {
            if (visited[next]) {
                continue;
            }
            dfs(next);
        }
    }
}
