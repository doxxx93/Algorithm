import java.util.*;
import java.io.*;

class Main {

    static int n;
    static int[] c;
    static int[] p;
    static int[][] a;
    static int[][] d;

    static boolean[] visited;
    static int[] order;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        c = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        p = new int[n + 1];
        a = new int[n + 1][n];
        d = new int[n + 1][n];
        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(br.readLine());
            for (int j = 0; j < p[i]; j++) {
                st = new StringTokenizer(br.readLine());
                a[i][j] = Integer.parseInt(st.nextToken());
                d[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n + 1];
        order = new int[n + 1];
        answer = Integer.MAX_VALUE;
        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            int[] tempC = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                tempC[i] = c[i];
            }
            int sum = 0;
            int index;
            for (int i = 0; i < n; i++) {
                index = order[i];
                sum+= tempC[index];
                for (int j = 0; j < p[index]; j++) {
                    if (tempC[a[index][j]] - d[index][j] < 1) {
                        tempC[a[index][j]] = 1;
                    } else {
                        tempC[a[index][j]] -= d[index][j];
                    }
                }
            }
            answer = Math.min(answer, sum);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
