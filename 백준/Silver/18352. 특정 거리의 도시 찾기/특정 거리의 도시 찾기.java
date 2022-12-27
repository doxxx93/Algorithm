import java.io.*;
import java.util.*;

public class Main {

    static int n, m, k, x;

    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        distance = new int[n + 1];
        Arrays.fill(distance, -1);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
        }

        bfs(x);
    }

    private static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        distance[x] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                if (distance[next] == -1) {
                    distance[next] = distance[now] + 1;
                    q.offer(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                sb.append(i).append("\n");
            }
        }

        if (sb.length() == 0) {
            sb.append(-1);
        }

        System.out.println(sb);
    }
}
