import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = Integer.parseInt(br.readLine());

            int ans = 1;

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());

                st.nextToken();

                char node = st.nextToken().charAt(0);

                if (st.hasMoreTokens()) {
                    if (node >= '0' && node <= '9') {
                        ans = 0;
                    }
                } else {
                    if (node < '0' || node > '9') {
                        ans = 0;
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
