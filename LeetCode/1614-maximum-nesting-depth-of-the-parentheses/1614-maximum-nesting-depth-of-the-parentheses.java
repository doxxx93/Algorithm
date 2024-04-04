import java.util.Stack;

class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int maxDepth = 0;
        int currentDepth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (c == ')') {
                stack.pop();
                currentDepth--;
            }
        }
        return maxDepth;
    }
}