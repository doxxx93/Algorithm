import java.io.*;
import java.util.*;

public class Main {

    static int n;
    private static List<Node>[] tree;
    private static int end;
    private static int max;
    private static boolean[] visited;

    static class Node {

        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }

        visited = new boolean[n + 1];
        max = Integer.MIN_VALUE;
        dfs(1, 0);

        visited = new boolean[n + 1];
        max = Integer.MIN_VALUE;
        dfs(end, 0);
        System.out.println(max);
    }

    private static void dfs(int start, int weight) {
        visited[start] = true;
        if (weight > max) {
            max = weight;
            end = start;
        }
        for (Node node : tree[start]) {
            if (!visited[node.to]) {
                dfs(node.to, weight + node.weight);
            }
        }
    }
}
