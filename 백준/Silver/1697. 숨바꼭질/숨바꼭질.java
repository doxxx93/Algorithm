import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100001];
        int[] distance = new int[100001];

        int[] multiplier = {1, 1, 2};
        int[] adder = {-1, 1, 0};

        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);
        visited[n] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next = cur * multiplier[i] + adder[i];
                if ( 0<=next && next<100001 && !visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    distance[next] = distance[cur] + 1;
                }
            }
        }
        System.out.println(distance[k]);
    }
}
