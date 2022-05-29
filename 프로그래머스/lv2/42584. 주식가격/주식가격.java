import java.util.Arrays;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int count = 0;
            Loop2:
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    count++;
                } else {
                    count++;
                    break Loop2;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}