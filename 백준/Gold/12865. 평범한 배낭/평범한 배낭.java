import java.io.*;
import java.util.*;

public class Main {

    static int[] weight;
    static int[] value;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        weight = new int[n];
        value = new int[n];
        dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(knapsack(n - 1, k));
    }

    private static int knapsack(int i, int k) {
        if (i < 0) {
            return 0;
        }

        if (dp[i][k] == 0) {
            if (k - weight[i] >= 0) {
                dp[i][k] = Math.max(knapsack(i - 1, k), knapsack(i - 1, k - weight[i]) + value[i]);
            } else {
                dp[i][k] = knapsack(i - 1, k);
            }
        }
        return dp[i][k];
    }
}
