class Solution {
    public int solution(int n) {
        int answer = 0;
        int[][] dp = new int[n+1][n+1];

        dp[1][1] = 1;


        for(int i = 0; i<=n; i++){
            dp[0][i] = 1;
        }

        for(int i = 1; i<=n; i++){
            for(int j = i; j<=n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }


        return dp[n][n];
    }
}