import java.io.*;
import java.util.*;

public class Main {

    static class Bridge {

        int x, y, cost;

        Bridge(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static int n;
    static int m;
    static int start;
    static int end;
    static int[] parent;
    static int[] rank;
    static PriorityQueue<Bridge> bridges = new PriorityQueue<>(Comparator.comparingInt(o -> -o.cost));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = toInt(st);
        m = toInt(st);
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            bridges.add(new Bridge(toInt(st), toInt(st), toInt(st)));
        }

        st = new StringTokenizer(br.readLine());
        start = toInt(st);
        end = toInt(st);

        System.out.println(mst());
    }

    private static int mst() {
        int result = 0;
        while (!bridges.isEmpty()) {
            Bridge bridge = bridges.poll();
            union(bridge.x, bridge.y);
            if (find(start) == find(end)) {
                result = bridge.cost;
                break;
            }
        }
        return result;
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (rank[x] > rank[y]) {
            parent[y] = x;
        } else {
            parent[x] = y;
            if (rank[x] == rank[y]) {
                rank[y]++;
            }
        }
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static int toInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}
