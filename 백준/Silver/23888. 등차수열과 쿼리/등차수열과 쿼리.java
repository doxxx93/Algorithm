import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long d = Long.parseLong(st.nextToken());
        long q = Long.parseLong(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (i == 1) {
                long sumR = r * (2 * a + (r - 1) * d) / 2;
                long sumL = (l - 1) * (2 * a + (l - 2) * d) / 2;
                sb.append(sumR - sumL).append("\n");
            } else if (i == 2) {
                if (r == l) {
                    sb.append(a + d * (l - 1)).append("\n");
                } else {
                    sb.append(gcd(a, d)).append("\n");
                }
            }
        }
        System.out.println(sb.toString().trim());
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
