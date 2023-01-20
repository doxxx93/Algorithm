import java.io.*;
import java.util.*;

public class Main {

    static int t, n;
    static int[] p;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            p = new int[n + 1];
            v = new boolean[n + 1];

            StringTokenizer st;

            for (int i = 1; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                p[y] = x;
            }

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lca(x, y);
        }
    }

    private static void lca(int x, int y) {
        while (x > 0) {
            v[x] = true;
            x = p[x];
        }

        while (y > 0) {
            if (v[y]) {
                System.out.println(y);
                break;
            }
            y = p[y];
        }
    }
}
