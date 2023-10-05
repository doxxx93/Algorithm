import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] units = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            units[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        dp = new int[m + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = units[i]; j <= m; j++) {
                dp[j] += dp[j - units[i]];
            }
        }

        System.out.println(dp[m]);
    }
}
