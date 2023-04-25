import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    static boolean[] visited;
    static Set<Integer> result;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        result = new TreeSet<>();
        count = 0;
        for (int i = 1; i < n + 1; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(i);
            Arrays.fill(visited, false);
        }
        System.out.println(count);
        result.forEach(System.out::println);
    }

    public static void dfs(int cur) {
        visited[cur] = true;
        int next = arr[cur];
        if (visited[next]) {
            if (result.contains(next)) {
                return;
            }
            result.add(next);
            count++;
            return;
        }
        dfs(next);
    }
}