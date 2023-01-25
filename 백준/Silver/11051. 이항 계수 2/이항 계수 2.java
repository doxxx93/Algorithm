import java.io. *;
import java.util. *;

public class Main {

    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][k + 1];
        System.out.println(bc(n, k) % 10007);
    }

    private static int bc(int n, int k) {
        if (dp[n][k] > 0) {
            return dp[n][k];
        }
        if (n == k || k == 0) {
            return dp[n][k] = 1;
        }
        return dp[n][k] = (bc(n - 1, k - 1) + bc(n - 1, k)) % 10007;
    }
}
