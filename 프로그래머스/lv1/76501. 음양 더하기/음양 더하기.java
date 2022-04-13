class Solution {

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            answer += isNegative(absolutes[i], signs[i]);
        }

        return answer;
    }

    public int isNegative(int absolute, boolean sign) {
        if (sign) {
            return absolute;
        } else {
            return -absolute;
        }
    }
}