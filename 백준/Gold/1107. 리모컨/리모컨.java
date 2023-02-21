import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[10];
        if (m!= 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                arr[Integer.parseInt(st.nextToken())] = true;
            }
        }
        if (n == 100) {
            System.out.println(0);
            return;
        }

        int ans = Math.abs(100 - n);
        for (int i = 0; i < 1000001; i++) {
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                if (arr[s.charAt(j) - '0']) {
                    break;
                }
                if (j == s.length() - 1) {
                    ans = Math.min(ans, Math.abs(n - i) + s.length());
                }
            }
        }
        System.out.println(ans);
    }
}