import java.io.*;
import java.util.*;

public class Main {

    static int[] arr = new int[10];
    static int[] ans = new int[10];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int idx, int sum) {
        if (idx == 10) {
            if (sum >= 5) {
                answer++;
            }
            return;
        }
        for (int i = 1; i <= 5; i++) {
            if (idx >= 2 && ans[idx - 1] == i && ans[idx - 2] == i) {
                continue;
            }
            ans[idx] = i;
            dfs(idx + 1, sum + (arr[idx] == i ? 1 : 0));
        }
    }
}
