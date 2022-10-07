import java.io.*;
import java.util.*;

public class Main {

    static int n, m, k, x;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        distance = new int[n + 1];
        Arrays.fill(distance, -1);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
        distance[x] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);
                if (distance[next] == -1) {
                    distance[next] = distance[cur] + 1;
                    q.offer(next);
                }
            }
        }
        boolean check = false;
        for (int i = 1; i < n + 1; i++) {
            if (distance[i] == k) {
                System.out.println(i);
                check = true;
            }
        }
        if (!check) {
            System.out.println(-1);
        }
    }
}
