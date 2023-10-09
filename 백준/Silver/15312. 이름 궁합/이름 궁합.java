import java.io.*;

public class Main {

    private static final int[] STROKES = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2,
        2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();
        int len = a.length * 2;
        int idx = 0;
        int[] dp = new int[(len + 1) * len / 2 - 1];

        for (int i = 0; i < a.length; i++) {
            dp[idx++] = STROKES[a[i] - 'A'];
            dp[idx++] = STROKES[b[i] - 'A'];
        }
        while (--len > 1) {
            for (int i = 0; i < len; i++, idx++) {
                dp[idx] = (dp[idx - len - 1] + dp[idx - len]) % 10;
            }
        }
        System.out.println(dp[dp.length - 2] + String.valueOf(dp[dp.length - 1]));
    }
}
