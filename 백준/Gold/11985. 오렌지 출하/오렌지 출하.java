import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long[] oranges = new long[n + 1];
        long[] dp = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            oranges[i] = Long.parseLong(br.readLine());
            dp[i] = k * i;
        }

        for (int i = 0; i < n; i++) {
            long min = oranges[i + 1];
            long max = oranges[i + 1];

            for (int j =1; j <= m && i + j <= n; j++) {
                min = Math.min(min, oranges[i + j]);
                max = Math.max(max, oranges[i + j]);
                dp[i + j] = Math.min(dp[i + j], dp[i] + k + (j * (max - min)));
            }
        }

        System.out.println(dp[n]);
    }
}
