import java.io.*;
import java.util.*;

public class Main {

    static int n, p, res, bit, cnt;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String input = br.readLine();
        bit = 0;
        cnt = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'Y') {
                bit |= (1 << i);
                cnt++;
            }
        }

        dp = new int[1 << n][n + 1];
        p = Integer.parseInt(br.readLine());
        for (int i = 0; i < (1 << n); i++) {
            Arrays.fill(dp[i], -1);
        }

        res = solve(bit, cnt);

        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(res);
    }

    static int solve(int bit, int cnt) {
        if (cnt >= p) {
            return 0;
        }

        if (dp[bit][cnt] != -1) {
            return dp[bit][cnt];
        }

        dp[bit][cnt] = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if ((bit & (1 << i)) != 0) {
                for (int j = 0; j < n; j++) {
                    if ((bit & (1 << j)) == 0) {
                        dp[bit][cnt] = Math.min(dp[bit][cnt],
                            solve(bit | (1 << j), cnt + 1) + arr[i][j]);
                    }
                }
            }
        }
        return dp[bit][cnt];
    }
}
