import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        int[] y = new int[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        int dist = 0;
        for (int i = 1; i < n; i++) {
            dist += abs(x[i] - x[i - 1]) + abs(y[i] - y[i - 1]);
        }
        int largeSkip = 0;
        for (int i = 1; i < n - 1; i++) {
            int noSkip =
                abs(x[i + 1] - x[i]) + abs(x[i] - x[i - 1]) + abs(y[i + 1] - y[i])
                + abs(y[i] - y[i - 1]);
            int skip = abs(x[i + 1] - x[i - 1]) + abs(y[i + 1] - y[i - 1]);
            largeSkip = Math.max(largeSkip, noSkip - skip);
        }
        System.out.println(dist - largeSkip);
    }

    private static int abs(int x) {
        return x < 0 ? -x : x;
    }
}
