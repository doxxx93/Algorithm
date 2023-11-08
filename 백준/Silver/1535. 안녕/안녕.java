import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] lossAndJoy = new int[n][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lossAndJoy[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lossAndJoy[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][100];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 100; j++) {
                if (j >= lossAndJoy[i-1][0]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-lossAndJoy[i-1][0]] + lossAndJoy[i-1][1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][99]);
    }
}
