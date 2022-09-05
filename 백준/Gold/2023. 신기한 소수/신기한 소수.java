import java.io.*;
import java.util.*;

class Main {

    static int n;
    static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        dfs(0, 0);
        System.out.println(sb);
    }

    private static void dfs(int depth, int prev) {
        if (depth == n && isPrime(prev)) {
            sb.append(prev).append("\n");
            return;
        }

        for (int i = 1; i < 10; i++) {
            int next = prev * 10 + i;
            if (isPrime(next)) {
                dfs(depth + 1, next);
            }
        }
    }

    private static boolean isPrime(int candidate) {
        if (candidate == 1) {
            return false;
        }
        for (int i = 2; i * i <= candidate; i++) {
            if (candidate % i == 0) {
                return false;
            }
        }
        return true;
    }
}
