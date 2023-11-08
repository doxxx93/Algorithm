import java.util.*;

class Solution {

    public int solution(String s) {
        String ss = s.repeat(2);
        int answer = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            String sub = ss.substring(i, i + len);
            if (isGood(sub)) {
                answer++;
            }
        }
        return answer;
    }

    public boolean isGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() == '(' && c == ')') {
                    stack.pop();
                } else if (stack.peek() == '{' && c == '}') {
                    stack.pop();
                } else if (stack.peek() == '[' && c == ']') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}
