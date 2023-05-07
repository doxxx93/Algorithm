import java.util.*;
class Solution {
    public int solution(int[] num_list) {
        int sum = Arrays.stream(num_list).sum();
        int mul = Arrays.stream(num_list).reduce(1, (a, b) -> a * b);
        if (mul < sum * sum){
            return 1;
        }
        return 0;
    }
}