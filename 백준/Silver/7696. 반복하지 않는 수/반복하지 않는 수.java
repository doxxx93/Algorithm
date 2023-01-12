import java.io.*;
import java.util.*;

public class Main {

    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ans = new int[1000001];
        make();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            sb.append(ans[n]).append("\n");
        }
        System.out.println(sb);
    }

    private static void make() {
        int rep = 1;
        int cur = 1;
        boolean[] used = new boolean[10];
        while (rep <= 1000000) {
            int temp = cur;
            Arrays.fill(used, false);
            boolean good = true;
            while (temp > 0) {
                if (used[temp % 10]) {
                    good = false;
                    break;
                }
                used[temp % 10] = true;
                temp = temp / 10;
            }
            if (good) {
                ans[rep++] = cur;
            }
            cur++;
        }
    }
}
