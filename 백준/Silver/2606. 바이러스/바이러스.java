import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int p;
    static List<ArrayList<Integer>> adj;

    static int count = 0;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        p = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        checked = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        StringTokenizer st;

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        dfs(1);

        System.out.println(count - 1);
    }

    private static void dfs(int cur) {
        checked[cur] = true;
        count++;
        for (int nxt : adj.get(cur)) {
            if (checked[nxt]) {
                continue;
            }
            dfs(nxt);
        }
    }
}