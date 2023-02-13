import java.io.*;
import java.util.*;

public class Main {

    static final int JOINT = 1;
    static final int DISJOINT = 0;
    static int[] parent;
    static int[] rank;
    static int[] size;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int type = Integer.parseInt(st.nextToken());
                if (type == JOINT) {
                    union(i, j);
                }
            }
        }
        
        st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken()) - 1;
        for (int i = 1; i < m; i++) {
            int cur = Integer.parseInt(st.nextToken()) - 1;
            if (find(prev) != find(cur)) {
                System.out.println("NO");
                return;
            }
            prev = cur;
        }
        System.out.println("YES");
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return;
        }
        if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        } else if (rank[rootB] > rank[rootA]) {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
            size[rootA] += size[rootB];
        }
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}