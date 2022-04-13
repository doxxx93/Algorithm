import java.util.Arrays;

class Solution {

    public int solution(String s) {
        int answer = 0;

        char[] arr = s.toCharArray();
        if (arr[0] == '-') {
            return -1 * Integer.parseInt(s.valueOf(arr, 1, arr.length - 1));
        } else if (arr[0] == '+') {
            return Integer.parseInt(s.valueOf(arr, 1, arr.length - 1));
        } else {
            return Integer.parseInt(s);
        }

    }

}