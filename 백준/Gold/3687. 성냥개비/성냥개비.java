import java.io.*;
import java.util.*;

public class Main {

    static long[] minDP = new long[101];
    static final long[] MATCH = {1, 7, 4, 2, 0, 8};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Arrays.fill(minDP, Long.MAX_VALUE);
        minDP[2] = 1;
        minDP[3] = 7;
        minDP[4] = 4;
        minDP[5] = 2;
        minDP[6] = 6;
        minDP[7] = 8;
        minDP[8] = 10;
        for (int i = 9; i <= 100; i++) {
            for (int j = 2; j <= 7; j++) {
                minDP[i] = Math.min(minDP[i], minDP[i - j] * 10 + MATCH[j - 2]);
            }
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.print(minDP[n] + " ");
            int a = n / 2;
            int b = n % 2;

            if (b == 1) {
                System.out.print(7);
                a--;
            }
            System.out.println("1".repeat(a));
        }

    }
}
