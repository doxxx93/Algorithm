import java.util.*;

class Solution {

    public int solution(String[] arr) {
        int op = (arr.length - 1) / 2;
        int[][] max = new int[op + 1][op + 1];
        int[][] min = new int[op + 1][op + 1];
        for (int i = 0; i < op + 1; i++) {
            Arrays.fill(max[i], Integer.MIN_VALUE);
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < op + 1; i++) {
            max[i][i] = Integer.parseInt(arr[i * 2]);
            min[i][i] = Integer.parseInt(arr[i * 2]);
        }

        // operators are + , -
        for (int i = 1; i < op + 1; i++) {
            for (int j = 0; j < op + 1 - i; j++) {
                for (int k = j; k < j + i; k++) {
                    int a = max[j][k];
                    int b = max[k + 1][j + i];
                    int c = min[j][k];
                    int d = min[k + 1][j + i];
                    if (arr[k * 2 + 1].equals("+")) {
                        max[j][j + i] = Math.max(max[j][j + i], a + b);
                        min[j][j + i] = Math.min(min[j][j + i], c + d);
                    } else {
                        max[j][j + i] = Math.max(max[j][j + i], a - d);
                        min[j][j + i] = Math.min(min[j][j + i], c - b);
                    }
                }
            }
        }
        return max[0][op];
    }
}
