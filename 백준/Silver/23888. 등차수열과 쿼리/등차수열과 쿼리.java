import java.io.*;
import java.util.*;

public class Main {

    static long a, d, t, l, r;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        d = Long.parseLong(st.nextToken());
        sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            t = Long.parseLong(st.nextToken());
            l = Long.parseLong(st.nextToken());
            r = Long.parseLong(st.nextToken());

            if (t == 1) {
                sb.append(sum()).append("\n");
                continue;
            }
            if (t == 2) {
                if (r == l) {
                    sb.append(a+d*(r-1)).append("\n");
                    continue;
                }
                sb.append(gcd(a, d)).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static long sum() {
        return r * (2 * a + (r - 1) * d) / 2 - (l - 1) * (2 * a + (l - 2) * d) / 2;
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
