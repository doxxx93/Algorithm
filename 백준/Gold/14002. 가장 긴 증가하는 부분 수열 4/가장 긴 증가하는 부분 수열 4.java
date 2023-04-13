import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    static int[] dp;
    static int[] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp = new int[n];
        prev = new int[n];
        Arrays.fill(dp, -1);
        Arrays.fill(prev, -1);
        System.out.println(findLISLen());
        System.out.println(elements());
        // lis' length
        // lis' elements
    }

    private static String elements() {
        int max = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (index != -1) {
            sb.append(arr[index]).append(" ");
            index = prev[index];
        }
        return sb.toString();
    }

    private static int findLISLen() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, lis(i));
        }
        return max;
    }

    private static int lis(int index) {
        if (dp[index] != -1) {
            return dp[index];
        }
        int max = 1;
        for (int i = index + 1; i < n; i++) {
            if (arr[i] > arr[index]) {
                int len = lis(i) + 1;
                if (len > max) {
                    max = len;
                    prev[index] = i;
                }
            }
        }
        return dp[index] = max;
    }
}