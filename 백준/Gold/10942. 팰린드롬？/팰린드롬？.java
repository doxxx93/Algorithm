import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] dp = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
            if (arr[i] == arr[i - 1]) {
                dp[i - 1][i] = true;
            }
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                if (arr[j] == arr[j + i] && dp[j + 1][j + i - 1]) {
                    dp[j][j + i] = true;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if (dp[s][e]) {
                sb.append(1).append('\n');
                continue;
            }
            sb.append(0).append('\n');
        }
        System.out.println(sb);
    }
}
