import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            long[] arr = euclid(k, c);
            if (arr[1] != 1) {
                sb.append("IMPOSSIBLE").append("\n");
            } else {
                long x = arr[0];
                x = (x % k + k) % k;
                x = Math.max(x, (k + c) / c);

                if (x <= 1e9) {
                    sb.append(x).append("\n");
                } else {
                    sb.append("IMPOSSIBLE").append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    private static long[] euclid(int a, int b) {
        long r0 = a, r1 = b;
        long s0 = 1, s1 = 0;
        long t0 = 0, t1 = 1;

        long tmp;
        while (r1 != 0) {
            long q = r0 / r1;

            tmp = r0 - q * r1;
            r0 = r1;
            r1 = tmp;

            tmp = s0 - q * s1;
            s0 = s1;
            s1 = tmp;

            tmp = t0 - q * t1;
            t0 = t1;
            t1 = tmp;
        }

        return new long[]{t0, r0};

    }
}
