import java.util.Stack;

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> ls = new Stack<>();
        Stack<Integer> ss = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(' -> ls.push(i);
                case '*' -> ss.push(i);
                default -> {
                    if (!ls.isEmpty()) {
                        ls.pop();
                    } else if (!ss.isEmpty()) {
                        ss.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        while (!ls.isEmpty() && !ss.isEmpty()) {
            if (ls.pop() > ss.pop()) {
                return false;
            }
        }
        return ls.isEmpty();
    }
}
