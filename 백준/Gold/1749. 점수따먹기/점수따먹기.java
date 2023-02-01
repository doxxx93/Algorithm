import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][] prefix = new long[n + 1][m + 1];

        for (int row = 1; row < n + 1; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col < m + 1; col++) {
                prefix[row][col] =
                    prefix[row][col - 1] + prefix[row - 1][col] - prefix[row - 1][col - 1]
                        + Long.parseLong(st.nextToken());
            }
        }

        long max = Integer.MIN_VALUE;
        for (int row1 = 1; row1 < n + 1; row1++) {
            for (int col1 = 1; col1 < m + 1; col1++) {
                for (int row2 = row1; row2 < n + 1; row2++) {
                    for (int col2 = col1; col2 < m + 1; col2++) {
                        long result =
                            prefix[row2][col2] - prefix[row1 - 1][col2] - prefix[row2][col1 - 1]
                                + prefix[row1 - 1][col1 - 1];
                        max = Math.max(max, result);
                    }
                }
            }
        }
        System.out.println(max);
    }
}