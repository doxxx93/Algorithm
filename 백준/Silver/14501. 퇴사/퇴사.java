import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] time;
    static int[] price;
    static boolean[] check;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        time = new int[n];
        price = new int[n];
        check = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.println(max);
    }

    private static void dfs(int idx, int sum) {
        if (idx == n) {
            max = Math.max(max, sum);
            return;
        }
        if (idx + time[idx] <= n) {
            dfs(idx + time[idx], sum + price[idx]);
        }
        dfs(idx + 1, sum);
    }
}
