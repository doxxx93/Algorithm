import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String cur = br.readLine();
            if (cur.equals("end")) {
                break;
            }

            int n = cur.length();
            char[] str = cur.toCharArray();

            int[][] m = new int[n][n + 1];
            for (int len = 2; len <= n; len++) {
                for (int i = 0; i < n - len + 1; i++) {
                    int max = 0;
                    if ((str[i] == '(' && str[i + len - 1] == ')') ||
                        (str[i] == '[' && str[i + len - 1] == ']')) {
                        max = 2 + m[i + 1][len - 2];
                    }
                    for (int j = i + 1; j <= i + len - 1; j++) {
                        max = Math.max(max, m[i][j - i] + m[j][i + len - j]);
                    }
                    m[i][len] = max;
                }
            }
            sb.append(m[0][n]).append("\n");
        }
        System.out.println(sb);
    }
}
