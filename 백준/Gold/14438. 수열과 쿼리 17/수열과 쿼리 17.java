import java.io.*;
import java.util.*;

public class Main {

    static long[] arr;
    static long[] tree;
    static int len;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        tree = new long[4 * n];
        len = 2 * n;
        Arrays.fill(tree, Integer.MAX_VALUE);
        build(1, 0, n - 1);
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
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
            tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
        }
    }

    private static void update(int node, int start, int end, int index, long value) {
        if (start == end) {
            arr[index] = value;
            tree[node] = value;
        } else {
            int mid = (start + end) / 2;
            if (index <= mid) {
                update(node * 2, start, mid, index, value);
            } else {
                update(node * 2 + 1, mid + 1, end, index, value);
            }
            tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
        }
    }

    private static long get(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return Integer.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return Math.min(get(node * 2, start, mid, left, right), get(node * 2 + 1, mid + 1, end, left, right));
    }
}