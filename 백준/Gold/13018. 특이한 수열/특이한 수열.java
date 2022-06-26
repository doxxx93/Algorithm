import java.util.*;
import java.io.*;

class Main {

    static int n, k, s;
    static int[] A;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        input();
        sb = new StringBuilder();
        if (n == k) {
            System.out.println("Impossible");
            return;
        }
        s = 1;
        k = n - k;
        if (k % 2 == 1) {
            sb.append(1 + " ");
            k--;
            s++;
        }
        for (int i = s; i <= n; i++) {
            if (k != 0) {
                sb.append(i + 1).append(" ").append(i).append(" ");
                k -= 2;
                i++;
            } else {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString());
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
    }
}
