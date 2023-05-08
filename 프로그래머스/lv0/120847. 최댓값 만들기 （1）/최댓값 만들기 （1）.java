import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        // return max multiple of 2 elements in array
        int ans = 0;
        for(int i = 0 ; i < numbers.length ; i++){
            for(int j = i+1 ; j < numbers.length ; j++){
                ans = Math.max(ans, numbers[i] * numbers[j]);
            }
        }
        return ans;
    }
}