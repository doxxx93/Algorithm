import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int[] maxTree;
    static int[] minTree;
    static int n, len;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        maxTree = new int[4 * n];
        minTree = new int[4 * n];
        len = 2 * n;
        build(1,0, n - 1);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            sb.append(minQuery(1, 0, n - 1, left - 1, right - 1)).append(" ");
            sb.append(maxQuery(1, 0, n - 1, left - 1, right - 1)).append("\n");
        }
        System.out.println(sb);
    }

    private static void build(int node, int start, int end) {
        if (start == end) {
            maxTree[node] = arr[start];
            minTree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(node * 2, start, mid);
            build(node * 2 + 1, mid + 1, end);
            maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
            minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
        }
    }

    private static int minQuery(int index, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return Integer.MAX_VALUE;
        }
        if (left <= start && right >= end) {
            return minTree[index];
        }

        int mid = (start + end) / 2;
        return Math.min(minQuery(index * 2, start, mid, left, right),
            minQuery(index * 2 + 1, mid + 1, end, left, right));
    }

    private static int maxQuery(int index, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return Integer.MIN_VALUE;
        }
        if (left <= start && right >= end) {
            return maxTree[index];
        }
        int mid = (start + end) / 2;
        return Math.max(maxQuery(index * 2, start, mid, left, right),
            maxQuery(index * 2 + 1, mid + 1, end, left, right));
    }
}