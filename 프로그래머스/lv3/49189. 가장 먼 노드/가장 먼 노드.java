import java.util.*;

class Solution {

    boolean[] visited;
    int[] dist;
    List<Integer>[] adj;

    public int solution(int n, int[][] edge) {
        int answer = 0;
        adj = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] line : edge) {
            int from = line[0];
            int to = line[1];
            adj[from].add(to);
            adj[to].add(from);
        }

        visited = new boolean[n + 1];
        visited[1] = true;

        dist = new int[n + 1];

        Arrays.fill(dist, 20001);
        dist[1] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : adj[cur]) {
                if (visited[next]) {
                    continue;
                }
                q.add(next);
                visited[next] = true;
                dist[next] = dist[cur] + 1;
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (dist[i] == max) {
                answer++;
            }
        }

        return answer;
    }
}
