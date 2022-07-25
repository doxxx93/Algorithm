import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int x = (int) Math.pow(a, b % 4 == 0 ? 4 : b % 4) % 10;
            if (x == 0) {
                sb.append(10).append("\n");
            } else {
                sb.append(x).append("\n");
            }
        }
        System.out.println(sb);
    }
}