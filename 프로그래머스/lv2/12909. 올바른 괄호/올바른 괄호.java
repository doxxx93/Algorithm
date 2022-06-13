class Solution {

    boolean solution(String s) {
        boolean answer = true;
        int openCount = 0;
        int closeCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openCount++;
            } else if (s.charAt(i) == ')') {
                closeCount++;
            }
            if (openCount < closeCount) {
                answer = false;
                break;
            }
        }
        if (openCount != closeCount) {
            answer = false;
        }

        return answer;
    }
}