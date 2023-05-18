import java.util.*;

class Solution {

    // return collatz sequence start from n <= 1000
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        answer.add(n);
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            }
            else {
                n = n * 3 + 1;
            }
            answer.add(n);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}