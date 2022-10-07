import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int e;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static boolean[] visited;
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        dist = new int[n + 1];
        visited = new boolean[n + 1];

        Arrays.fill(dist, INF);
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, n);

        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, n);

        if (res1 >= INF && res2 >= INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(Math.min(res1, res2));
    }

    static class Node {

        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    public static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.end]) {
                continue;
            }
            visited[cur.end] = true;

            for (Node node : graph[cur.end]) {
                if (dist[node.end] > dist[cur.end] + node.weight) {
                    dist[node.end] = dist[cur.end] + node.weight;
                    pq.add(new Node(node.end, dist[node.end]));
                }
            }
        }
        return dist[end];
    }
}
