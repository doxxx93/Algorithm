import java.io.*;
import java.util.*;

public class Main {

    static int n, m, k;
    static long[] nodes;
    static long[] tree;
    static long[] lazy;

    static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = nodes[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    static void propagate(int start, int end, int node) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    static void update(int start, int end, int node, int left, int right, long diff) {
        propagate(start, end, node);
        if (right < start || end < left) {
            return;
        }
        if (left <= start && end <= right) {
            tree[node] += (end - start + 1) * diff;
            if (start != end) {
                lazy[node * 2] += diff;
                lazy[node * 2 + 1] += diff;
            }
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, node * 2, left, right, diff);
        update(mid + 1, end, node * 2 + 1, left, right, diff);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        nodes = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = Long.parseLong(br.readLine());
        }

        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        int treeSize = (1 << (h + 1));
        tree = new long[treeSize];
        lazy = new long[treeSize];

        init(1, n, 1);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                long d = Long.parseLong(st.nextToken());
                update(1, n, 1, b, c, d);
            } else {
                System.out.println(sum(1, n, 1, b, c));
            }
        }
    }

    private static long sum(int start, int end, int node, int left, int right) {
        propagate(start, end, node);
        if (right < start || end < left) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left,
            right);
    }
}
