class Solution {

    int max = 10000000;

    public int[] solution(long begin, long end) {
        int b = (int) begin;
        int e = (int) end;

        int[] answer = new int[e - b + 1];

        for (int i = b; i <= e; i++) {
            answer[i - b] = numberBlock(i);
        }

        return answer;
    }

    public int numberBlock(int number) {
        if (number == 1) {
            return 0;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0 && (number / i) <= max) {
                return number / i;
            }
        }
        return 1;
    }
}