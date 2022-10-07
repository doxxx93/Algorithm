import java.io.*;
import java.util.*;

public class Main {

    static final int INF = 1 << 30;
    static int n, m, x;
    static List<Node>[] graph;
    static List<Node>[] rgraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        rgraph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
            rgraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, dist));
            rgraph[to].add(new Node(from, dist));
        }
        int[] dist1 = dijkstra(graph);
        int[] dist2 = dijkstra(rgraph);

        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            answer = Math.max(answer, dist1[i] + dist2[i]);
        }
        System.out.println(answer);
    }

    public static int[] dijkstra(List<Node>[] graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[x] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        pq.add(new Node(x, 0));
        boolean[] visited = new boolean[n + 1];
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int cur = node.to;
            if (visited[cur]) {
                continue;
            }
            visited[cur] = true;
            for (Node next : graph[cur]) {
                if (dist[next.to] > dist[cur] + next.dist) {
                    dist[next.to] = dist[cur] + next.dist;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
        return dist;
    }

    static class Node {

        int to;
        int dist;

        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
}
