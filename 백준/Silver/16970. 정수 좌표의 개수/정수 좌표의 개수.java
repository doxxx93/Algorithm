import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int x1 = 0; x1 <= n; x1++) {
            for (int y1 = 0; y1 <= m; y1++) {
                for (int x2 = 0; x2 <= x1; x2++) {
                    for (int y2 = 0; y2 <= y1; y2++) {
                        if (x1 == x2) {
                            if (y1 - y2 + 1 == k) {
                                count++;
                            }
                        }
                        if (y1 == y2) {
                            if (x1 - x2 + 1 == k) {
                                count++;
                            }
                        }
                        if (x1 != x2 && y1 != y2 && gcd(x1 - x2, y1 - y2) == k - 1) {
                            count += 2;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}