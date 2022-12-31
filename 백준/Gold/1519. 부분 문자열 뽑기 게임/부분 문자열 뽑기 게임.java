import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n < 10) {
            System.out.println(-1);
            return;
        }

        int[] dp = new int[n + 1];
        for (int i = 10; i <= n; i++) {
            String s = String.valueOf(i);
            Set<String> set = new HashSet<>();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0') {
                    continue;
                }
                String str = "";
                for (int k = j; k < s.length(); k++) {
                    str += s.charAt(k);
                    if (!str.equals(s)) {
                        set.add(str);
                    }
                }
            }
            
            int min = Integer.MAX_VALUE;
            for (String str : set) {
                int num = Integer.parseInt(s);
                int temp = Integer.parseInt(str);
                if (dp[num - temp] == 0) {
                    min = Math.min(min, temp);
                }
            }
            if (min != Integer.MAX_VALUE) {
                dp[i] = min;
            }
        }

        if (dp[n] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n]);
        }
    }
}
