import java.util.*;

class Solution {

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long num = 1;
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            num *= i;
        }
        k--;
        while (idx < answer.length) {
            num /= (n--);
            int i = (int) (k / num);
            answer[idx++] = list.get(i);
            list.remove(i);
            k %= num;
        }
        return answer;
    }
}