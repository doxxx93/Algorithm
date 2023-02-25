import java.io.*;
import java.util.*;

public class Main {

    static int n;

    static int[] parent;
    static int[] rank;
    static long[] min;
    static long[] sum;
    static Pair[] pairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parent = new int[n];
        rank = new int[n];
        min = new long[n];
        sum = new long[n];
        pairs = new Pair[n];

        long best = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(Long.parseLong(st.nextToken()), i);
            best = Math.max(best, pairs[i].value * pairs[i].value);
        }

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            min[i] = pairs[i].value;
            sum[i] = pairs[i].value;
        }

        Arrays.sort(pairs);

        for (int i = n - 1; i >= 0; i--) {
            if (pairs[i].index > 0 && getMin(pairs[i].index) <= getMin(pairs[i].index - 1)) {
                union(pairs[i].index, pairs[i].index - 1);
            }
            if (pairs[i].index < n - 1 && getMin(pairs[i].index) <= getMin(pairs[i].index + 1)) {
                union(pairs[i].index, pairs[i].index + 1);
            }
            long value = getValue(pairs[i].index);
            best = Math.max(best, value);
        }

        System.out.println(best);
    }

    private static long getMin(int index) {
        return min[get(index)];
    }

    private static long getValue(int index) {
        index = get(index);
        return min[index] * sum[index];
    }

    public static int get(int index) {
        if (parent[index] != index) {
            parent[index] = get(parent[index]);
        }
        return parent[index];
    }

    public static void union(int a, int b) {
        a = get(a);
        b = get(b);
        if (a == b) {
            return;
        }
        if (rank[a] == rank[b]) {
            rank[a]++;
        }
        if (rank[a] > rank[b]) {
            parent[b] = a;
            sum[a] += sum[b];
            min[a] = Math.min(min[a], min[b]);
        } else {
            parent[a] = b;
            sum[b] += sum[a];
            min[b] = Math.min(min[a], min[b]);
        }
    }

    static class Pair implements Comparable<Pair> {

        long value;
        int index;

        public Pair(long value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            return Long.compare(this.value, o.value);
        }
    }
}