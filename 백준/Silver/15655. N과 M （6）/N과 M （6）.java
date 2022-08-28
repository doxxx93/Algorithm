import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] arr;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted()
            .toArray();
        result = new int[m];
        visited = new boolean[n + 1];

        dfs(0, 0);
    }

    private static void dfs(int start, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    result[depth] = arr[i];
                    dfs(i + 1, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
