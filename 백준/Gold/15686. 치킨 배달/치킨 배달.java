import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static List<int[]> chicken;
    static List<int[]> house;
    static int[] selected;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        chicken = new ArrayList<>();
        house = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                } else if (map[i][j] == 1) {
                    house.add(new int[]{i, j});
                }
            }
        }

        selected = new int[m];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < chicken.size(); i++) {
            selected[0] = i;
            min = Math.min(min, dfs(1));
        }
        System.out.println(min);

    }

    static int dfs(int depth) {
        if (depth == m) {
            int sum = 0;
            for (int[] h : house) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < m; i++) {
                    int[] c = chicken.get(selected[i]);
                    min = Math.min(min, getDistance(h[0], h[1], c[0], c[1]));
                }
                sum += min;
            }
            return sum;
        }

        int min = Integer.MAX_VALUE;
        for (int i = selected[depth - 1] + 1; i < chicken.size(); i++) {
            selected[depth] = i;
            min = Math.min(min, dfs(depth + 1));
        }
        return min;
    }

    static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}