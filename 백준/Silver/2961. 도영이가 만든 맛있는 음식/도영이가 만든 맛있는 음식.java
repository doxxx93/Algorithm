import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] s;
    static int[] b;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        s = new int[n];
        b = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }
        answer = Integer.MAX_VALUE;

        dfs(0, 1, 0);
        System.out.println(answer);
    }

    private static void dfs(int index, int sour, int bitter) {
        if (index == n) {
            if (sour == 1) {
                return;
            }
            answer = Math.min(answer, Math.abs(sour - bitter));
            return;
        }

        dfs(index + 1, sour * s[index], bitter + b[index]);
        dfs(index + 1, sour, bitter);
    }
}
