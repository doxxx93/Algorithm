import java.io.*;
import java.util.*;

public class Main {

    static final int[] r = {200, 180, 160, 140, 120, 100, 80, 60, 40, 20, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            while (n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int p = x * x + y * y;
                sum += point(p);
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    private static int point(int p) {
        for (int i = 0; i < 11; i++) {
            if (p > r[i] * r[i]) {
                return i;
            }
        }
        return 10;
    }
}
