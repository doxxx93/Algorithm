import java.io.*;

public class Main {

    static final int R = 0;
    static final int G = 1;
    static final int B = 2;

    static int[][] dp;
    static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n][3];
        cost = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            cost[i][R] = Integer.parseInt(line[R]);
            cost[i][G] = Integer.parseInt(line[G]);
            cost[i][B] = Integer.parseInt(line[B]);
        }
        System.out.println(Math.min(paint(n - 1, R), Math.min(paint(n - 1, G), paint(n - 1, B))));
    }

    private static int paint(int index, int color) {
        if (index == 0) {
            return cost[index][color];
        }
        if (dp[index][color] != 0) {
            return dp[index][color];
        }
        int min = Integer.MAX_VALUE;
        if (color == R) {
            min = Math.min(min, paint(index - 1, G) + cost[index][R]);
            min = Math.min(min, paint(index - 1, B) + cost[index][R]);
        } else if (color == G) {
            min = Math.min(min, paint(index - 1, R) + cost[index][G]);
            min = Math.min(min, paint(index - 1, B) + cost[index][G]);
        } else {
            min = Math.min(min, paint(index - 1, R) + cost[index][B]);
            min = Math.min(min, paint(index - 1, G) + cost[index][B]);
        }
        return dp[index][color] = min;
    }
}
