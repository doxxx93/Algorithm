import java.io. *;
import java.util. *;

public class Main {

    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dp = new long[n + 1][m + 1];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(dp(n, m)%1000000007);
    }

    private static long dp(int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (n == 1 && m == 1) {
            return 1;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        long result = (dp(n, m - 1) + dp(n - 1, m) + dp(n - 1, m - 1)) % 1000000007;
        return dp[n][m] = result;
    }
}
