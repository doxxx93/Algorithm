import java.io.*;
import java.util.*;

public class Main {

    static int n;

    static int[] tree;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new int[n * 4];
        result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            result += x - 1 - query(1, 1, n, 1, x);
            update(1, 1, n, x);
        }
        System.out.println(result);
    }

    private static int update(int node, int start, int end, int index) {
        if (index < start || index > end) {
            return tree[node];
        }
        if (start == end) {
            return tree[node] = 1;
        }
        int mid = (start + end) / 2;
        return tree[node] =
            update(node * 2, start, mid, index) + update(node * 2 + 1, mid + 1, end, index);
    }

    private static int query(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left,
            right);
    }
}