class Solution {

    public String solution(String p) {
        String answer = "";
        // if ( and ) are equal, then it is balanced
        // if ( and ) are equal and matched, then it is correct
        // convert to correct
        // if p is empty, return empty
        // split w to u and v. u is balanced, v could be empty
        // if u is correct, then return u + solution(v)
        // if u is not correct, then return ( + solution(v) + )
        // reverse u and remove first and last character
        // return u + solution(v)
        if (p.isEmpty()) {
            return p;
        }
        int left = 0;
        int right = 0;
        int index = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                index = i;
                break;
            }
        }
        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);
        if (isCorrect(u)) {
            answer = u + solution(v);
        } else {
            answer = "(" + solution(v) + ")";
            answer += reverse(u);
        }

        return answer;
    }

    private boolean isCorrect(String u) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (right > left) {
                return false;
            }
        }
        return true;
    }

    private String reverse(String u) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }
}
