import java.util.Arrays;

class Solution {

    public long solution(long n) {
        long answer = 0;
        int length = (int) (Math.log10(n) + 1);
        int[] num = new int[length];
        for (int i = 0; i < length; i++) {
            num[i] = (int) (n % 10);
            n /= 10;
        }
        Arrays.sort(num);
        for (int i = 0; i < length; i++) {
            answer += num[i] * (long) Math.pow(10, i);
        }
        return answer;
    }
}