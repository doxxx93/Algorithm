/*
오른쪽과 아래쪽으로만 움직인다.
최단경로의 개수 1000000007 로 나눈다.
오른쪽이나 아래가 puddles에 있다면 갈 수 없다.
*/
import java.util.*;

class Solution {
    
    private static final int MOD = (int) 1e9 + 7;
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        for (int[] puddle : puddles){
            dp[puddle[1]][puddle[0]] = -1;
        }
        
        dp[1][1] = 1;
        
        for (int i = 1; i<= n; i++){
            for (int j = 1; j<= m; j++){
                if (i == 1 && j == 1){
                    continue;
                }
                if(dp[i][j] == -1){
                    dp[i][j] = 0;
                    continue;
                }
                
                if( i != 1){
                    dp[i][j] += dp[i-1][j] % MOD;
                }
                
                if( j != 1){
                    dp[i][j] += dp[i][j-1] % MOD;
                }
            }
        }
        
        return dp[n][m] % MOD;
    }
}