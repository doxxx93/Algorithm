import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = (int) 1e6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] e = new boolean[MAX + 1];
        Arrays.fill(e, true);
        e[0] = e[1] = false;
        for (int i = 2; i * i <= MAX; i++) {
            if (e[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    e[j] = false;
                }
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                System.out.println(sb);
                return;
            }
            int a = 0, b;
            for (b = n; b >= 1; b--) {
                a = n - b;
                if (e[b] && e[a]) {
                    break;
                }
            }

            sb.append(n).append(" = ").append(a).append(" + ").append(b).append("\n");
        }
    }
}