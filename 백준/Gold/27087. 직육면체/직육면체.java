import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int count = 0;
            if (a % p == 0) {
                count++;
            }
            if (b % p == 0) {
                count++;
            }
            if (c % p == 0) {
                count++;
            }
            if (count >= 2) {
                System.out.println(1);
                continue;
            }
            System.out.println(0);
        }
    }
}
