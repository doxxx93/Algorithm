import static java.lang.Character.*;

class Solution {

    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        int sign = 1;
        int i = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            sign = s.charAt(0) == '-' ? -1 : 1;
            i++;
        }
        long res = 0;
        while (i < s.length() && isDigit(s.charAt(i))) {
            res = res * 10 + (s.charAt(i) - '0');
            if (res * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (res * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int) (res * sign);
    }

    
}