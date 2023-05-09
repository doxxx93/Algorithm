import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int len = num_list.length;
        int[] ans = Arrays.copyOf(num_list, len +1);
        if (num_list[len -2] < num_list[len-1]){
            ans[len] = num_list[len-1] - num_list[len -2];
        } else {
            ans[len] = 2 * num_list[len-1];
        }
        return ans;
    }
}