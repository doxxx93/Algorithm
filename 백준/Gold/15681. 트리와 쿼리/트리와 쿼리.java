import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int r;
    static int q;
    static ArrayList<Integer>[] list, tree;
    static int[] parent, size;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        tree = new ArrayList[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];
        for (var i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }

        while (--n > 0) {
            st = new StringTokenizer(br.readLine());
            var u = Integer.parseInt(st.nextToken());
            var v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        makeTree(r, -1);
        countSubtree(r);
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            sb.append(size[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.print(sb);
    }

    static void makeTree(int cur, int par) {
        for (var next : list[cur]) {
            if (next == par) {
                continue;
            }
            tree[cur].add(next);
            parent[next] = cur;
            makeTree(next, cur);
        }
    }

    static void countSubtree(int cur) {
        size[cur] = 1;
        for (var next : tree[cur]) {
            countSubtree(next);
            size[cur] += size[next];
        }
    }
}
