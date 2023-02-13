import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        st = new StringTokenizer(br.readLine());
        int know = Integer.parseInt(st.nextToken());
        int prev = 0;
        if (know == 0) {
            System.out.println(m);
            return;
        } else {
            prev = Integer.parseInt(st.nextToken());
            for (int i = 1; i < know; i++) {
                union(prev, Integer.parseInt(st.nextToken()));
            }
        }
        int[] top = new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int party = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            for (int j = 1; j < party; j++) {
                union(first, Integer.parseInt(st.nextToken()));
            }
            top[i] = first;
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            if (find(top[i]) != find(prev)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        }

        if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else if (rank[rootB] > rank[rootA]) {
            parent[rootA] = rootB;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}