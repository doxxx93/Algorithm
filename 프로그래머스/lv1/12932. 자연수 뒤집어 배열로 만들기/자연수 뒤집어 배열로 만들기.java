import java.util.Arrays;

class Solution {

    public int[] solution(long n) {
        int[] answer = {};
        int length = (int) (Math.log10(n) + 1);
        int[] num = new int[length];
        for (int i = 0; i < length; i++) {
            num[i] = (int) (n % 10);
            n /= 10;
        }
        return num;
    }
} 