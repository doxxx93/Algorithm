class Solution {

    public boolean solution(String s) {
        boolean answer = false;
        if (s.length() == 4 || s.length() == 6) {
            answer = isNumber(s);
        }

        return answer;
    }

    public boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}