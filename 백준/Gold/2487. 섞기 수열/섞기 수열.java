import java.io.*;
import java.util.*;

/**
 * 각 숫자가 같은 자리로 돌아오는 사이클을 모두 구한다.
 * 그 길이의 lcm을 출력한다.
 */
public class Main {

    static int n;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[n + 1];

        int ans = 1;
        for (int i = 1; i < n + 1; i++) {
            if (visited[i]) {
                continue;
            }
            int now = dfs(i, 0);
            ans = lcm(ans, now);
        }

        System.out.println(ans);
    }

    public static int dfs(int cur, int cnt) {
        if (visited[cur]) {
            return cnt;
        }
        visited[cur] = true;
        return dfs(arr[cur], cnt + 1);
    }

    public static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}