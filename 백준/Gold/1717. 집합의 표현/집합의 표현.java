import java.io.*;
import java.util.*;

public class Main {

    static final int UNION = 0;
    static final int FIND = 1;
    static int[] p;
    static int[] r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        p = new int[n + 1];
        r = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (type == UNION) {
                union(x, y);
            } else {
                System.out.println(find(x) == find(y) ? "YES" : "NO");
            }
        }

    }

    private static void union(int x, int y) {
        int r0 = find(x);
        int r1 = find(y);

        if (r1 == r0) {
            return;
        }

        if (r[r0] > r[r1]) {
            p[r1] = r0;
        } else if (r[r1] > r[r0]) {
            p[r0] = r1;
        } else {
            p[r1] = r0;
            r[r0]++;
        }
    }

    private static int find(int x) {
        int parent = p[x];

        if (x == parent) {
            return x;
        }

        return p[x] = find(parent);
    }
}