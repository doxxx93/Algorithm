import java.util.*;

class Solution {
    static int[][] cache = new int[31][31];
    public int solution(int balls, int share) {
        for(int i = 0; i< cache.length;i++){
            Arrays.fill(cache[i], -1);
        }
        return c(balls, share);
    }
    
    int c(int n, int r){
        if(r==0 || r ==n){
            return 1;
        }
        
        if (cache[n][r] != -1){
            return cache[n][r];
        }
        
        return cache[n][r] = c(n-1, r-1) + c(n-1,r);
    }
}