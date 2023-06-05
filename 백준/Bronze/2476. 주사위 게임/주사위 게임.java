import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int max = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == b && b == c) {
                max = Math.max(max, 10000 + a * 1000);
            } else if (a == b || a == c) {
                max = Math.max(max, 1000 + a * 100);
            } else if (b == c) {
                max = Math.max(max, 1000 + b * 100);
            } else {
                max = Math.max(max, Math.max(a, Math.max(b, c)) * 100);
            }
        }
        System.out.println(max);
    }
}
