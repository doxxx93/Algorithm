import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        result = new int[m];
        visited = new boolean[n + 1];

        dfs(0, 0);
        System.out.println(sb);
    }

    private static void dfs(int start, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < n; i++) {
                result[depth] = arr[i];
                dfs(i, depth + 1);
            }
        }
    }
}