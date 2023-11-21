import java.util.*;

class Solution {
    public List<Integer> solution(int n, int[] numlist) {
        List<Integer> res = new ArrayList<>();
        for (int x: numlist){
            if (x % n == 0){
                res.add(x);
            }
        }
        return res;
    }
}