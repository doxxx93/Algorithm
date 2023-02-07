import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            Map<String, Integer> map = new TreeMap<>();
            for (int i = 0; i <n; i++) {
                map.merge(st.nextToken(), 1, Integer::sum);
            }
            st = new StringTokenizer(br.readLine());
            int count = 0;
            for (int i = 0; i <m; i++) {
                count += map.getOrDefault(st.nextToken(), 0);
            }


            sb.append("#").append(test_case).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }
}