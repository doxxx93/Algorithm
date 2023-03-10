import java.util.*;

class Solution {

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new int[]{numbers[i], i});
            } else {
                while (!stack.isEmpty() && stack.peek()[0] < numbers[i]) {
                    answer[stack.pop()[1]] = numbers[i];
                }
                stack.push(new int[]{numbers[i], i});
            }
        }
        while (!stack.isEmpty()) {
            answer[stack.pop()[1]] = -1;
        }
        return answer;
    }
}
