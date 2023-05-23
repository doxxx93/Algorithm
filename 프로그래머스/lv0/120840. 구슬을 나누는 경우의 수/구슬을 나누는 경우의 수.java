import java.math.*;
import java.util.*;

class Solution {
//
//    static int[][] dp = new int[31][31];
//
//    public int solution(int balls, int share) {
//        for (int[] ints : dp) {
//            Arrays.fill(ints, -1);
//        }
//        return combination(balls, share);
//    }
//
//    int combination(int n, int r) {
//        if (r == 0 || r == n) {
//            return 1;
//        }
//
//        if (dp[n][r] != -1) {
//            return dp[n][r];
//        }
//
//        return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
//    }
    
    // use BigInteger
    public int solution(int balls, int share) {
        BigInteger answer = BigInteger.ONE;
        for (int i = 0; i < share; i++) {
            answer = answer.multiply(BigInteger.valueOf(balls - i)).divide(BigInteger.valueOf(i + 1));
        }
        return answer.intValue();
    }
    
}