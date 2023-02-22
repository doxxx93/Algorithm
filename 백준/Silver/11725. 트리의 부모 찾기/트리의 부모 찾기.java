import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] tree = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        int[] result = new int[n + 1];
        while (!q.isEmpty()) {
            Integer node = q.poll();
            for (Integer x : tree[node]) {
                if (!visited[x]) {
                    visited[x] = true;
                    q.add(x);
                    result[x] = node;
                }
            }
        }
        for (int i =2 ; i <= n; i++) {
            System.out.println(result[i]);
        }
    }
}