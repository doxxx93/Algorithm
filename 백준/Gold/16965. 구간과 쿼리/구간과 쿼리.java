import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static List<ArrayList<Integer>> adj;
    static List<int[]> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a, b, c;
        StringTokenizer st;
        adj = new ArrayList<>();
        edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                int[] input = {b, c};
                edges.add(input);
                for (int j = 0; j < edges.size() - 1; j++) {
                    if (canGo(input, edges.get(j))) {
                        adj.get(edges.size() - 1).add(j);
                    }
                    if (canGo(edges.get(j), input)) {
                        adj.get(j).add(edges.size() - 1);
                    }
                }
            } else {
                visited = new boolean[n];
                if (dfs(b - 1, c - 1)) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }
        }
    }

    public static boolean dfs(int cur, int x) {
        if (cur == x) {
            return true;
        }
        visited[cur] = true;
        for (int next : adj.get(cur)) {
            if (visited[next]) {
                continue;
            }

            if (dfs(next, x)) {
                return true;
            }
        }
        return false;
    }

    public static boolean canGo(int[] from, int[] to) {
        return (to[0] < from[0] && from[0] < to[1]) || (to[0] < from[1] && from[1] < to[1]);
    }
}