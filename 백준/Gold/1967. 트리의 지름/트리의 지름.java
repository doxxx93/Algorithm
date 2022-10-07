import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static ArrayList<Node>[] graph;
    static int distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        distance = 0;
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i, 0);
        }
        System.out.println(distance);
    }
    public static void dfs(int start, int sum) {
        for (Node node : graph[start]) {
            if (!visited[node.to]) {
                visited[node.to] = true;
                dfs(node.to, sum + node.weight);
            }
        }
        distance = Math.max(distance, sum);
    }

    static class Node {

        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
