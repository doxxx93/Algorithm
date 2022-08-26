import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] arr;
    static int[] num;
    static boolean[] visited;
    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        arr = new int[m];

        visited = new boolean[n];

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == m) {
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = num[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
