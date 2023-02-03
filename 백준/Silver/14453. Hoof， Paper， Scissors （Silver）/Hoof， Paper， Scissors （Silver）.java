import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        final String H = "H";
        final String P = "P";
        final String S = "S";

        int[][] prefix = new int[n + 1][3];
        for (int i = 1; i < n + 1; i++) {
            String input = br.readLine();
            if (input.equals(H)) {
                prefix[i][0]++;
            } else if (input.equals(P)) {
                prefix[i][1]++;
            } else if (input.equals(S)) {
                prefix[i][2]++;
            }
            prefix[i][0] += prefix[i - 1][0];
            prefix[i][1] += prefix[i - 1][1];
            prefix[i][2] += prefix[i - 1][2];
        }
        int answer = Math.max(prefix[n][0], Math.max(prefix[n][1], prefix[n][2]));

        for (int i = 2; i < n + 1; i++) {
            int left = Math.max(prefix[i - 1][0], Math.max(prefix[i - 1][1], prefix[i - 1][2]));
            int right = Math.max(prefix[n][0] - prefix[i - 1][0],
                Math.max(prefix[n][1] - prefix[i - 1][1], prefix[n][2] - prefix[i - 1][2]));
            answer = Math.max(answer, left + right);
        }
        System.out.println(answer);
    }
}