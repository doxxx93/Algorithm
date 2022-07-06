import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (b == a * a) {
            System.out.println(-a);
        } else {
            int sqrt = (int)Math.sqrt(a * a - b);
            int x1 = -1 * sqrt - a;
            int x2 = sqrt - a;
            System.out.println(Math.min(x1, x2) + " " + Math.max(x1, x2));
        }
    }
}
