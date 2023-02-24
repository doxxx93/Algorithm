import java.io.*;
import java.util.*;

public class Main {

    static final int MOD = 1000000007;
    static long[] arr;
    static long[] tree;
    static int len;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        tree = new long[4 * n];
        len = 2 * n;
        build(1, 0, n - 1);
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 1) {
                long c = Long.parseLong(st.nextToken());
                update(1, 0, n - 1, b - 1, c);
            } else {
                int c = Integer.parseInt(st.nextToken());
                sb.append(get(1, 0, n - 1, b - 1, c - 1)).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(node * 2, start, mid);
            build(node * 2 + 1, mid + 1, end);
            tree[node] = (tree[node * 2] % MOD * tree[node * 2 + 1]) % MOD;
        }
    }

    private static void update(int node, int start, int end, int index, long value) {
        if (start == end) {
            tree[node] = value;
        } else {
            int mid = (start + end) / 2;
            if (index <= mid) {
                update(node * 2, start, mid, index, value);
            } else {
                update(node * 2 + 1, mid + 1, end, index, value);
            }
            tree[node] = (tree[node * 2] % MOD * tree[node * 2 + 1]) % MOD;
        }
    }

    private static long get(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 1;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return (get(node * 2, start, mid, left, right) % MOD * get(node * 2 + 1, mid + 1, end, left,
            right)) % MOD;
    }
}