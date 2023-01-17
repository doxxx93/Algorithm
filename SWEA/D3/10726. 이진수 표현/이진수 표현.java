import java.io.*;
import java.util.*;

class Solution {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int x = (1 << n) - 1;
            if ((m & x) == x) {
                sb.append("#").append(test_case).append(" ON").append("\n");
                continue;
            }
            sb.append("#").append(test_case).append(" OFF").append("\n");
        }
        System.out.println(sb);
    }
}
