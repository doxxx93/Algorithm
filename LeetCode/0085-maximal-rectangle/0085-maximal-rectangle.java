class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = (j == n - 1) ? 1 : dp[i][j + 1] + 1;

                    int width = dp[i][j];
                    for (int k = i; k >= 0; k--) {
                        width = Math.min(width, dp[k][j]);
                        max = Math.max(max, width * (i - k + 1));
                    }
                }
            }
        }
        return max;
    }
}
