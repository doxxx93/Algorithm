import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] matrixPrefix = new int[n + 1][m + 1];

        for (int row = 1; row < n + 1; row++) {
            int[] input = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int col = 1; col < m + 1; col++) {
                matrixPrefix[row][col] =
                    matrixPrefix[row - 1][col] + matrixPrefix[row][col - 1] - matrixPrefix[row - 1][
                        col - 1] + input[col - 1];
            }
        }
        int result = 0;
        for (int row2 = n; row2 >= 1; row2--) {
            for (int col2 = m; col2 >= 1; col2--) {
                for (int row1 = row2; row1 >= 1; row1--) {
                    int col1 = 0;
                    int s = 1;
                    int e = col2;
                    while (s <= e) {
                        int mid = (s + e) / 2;
                        if (result < (row2 - row1 + 1) * (col2 - mid + 1)) {
                            col1 = mid;
                            s = mid + 1;
                        } else {
                            e = mid - 1;
                        }
                    }
                    for (; col1 >= 1; col1--) {
                        if (matrixPrefix[row2][col2] - matrixPrefix[row2][col1 - 1]
                            - matrixPrefix[row1 - 1][col2] + matrixPrefix[row1 - 1][col1 - 1]
                            == 0) {
                            result = (row2 - row1 + 1) * (col2 - col1 + 1);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
