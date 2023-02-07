import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int k = Integer.parseInt(br.readLine());
            String input = br.readLine();
            // input's substring dictionary
            Set<String> dict = new HashSet<>();
            for (int i = input.length() - 1; i >= 0; i--) {
                dict.add(input.substring(i));
            }
            List<String> list = new ArrayList<>(dict);
            Collections.sort(list);
            // print kth substring
            if (k <= list.size()) {
                sb.append("#").append(test_case).append(" ").append(list.get(k - 1)).append("\n");
                continue;
            }
            sb.append("#").append(test_case).append(" none").append("\n");
        }
        System.out.println(sb);
    }
}