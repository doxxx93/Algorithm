class Solution {

    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            answer = answer + numOfFactors(i) * i;
        }

        return answer;
    }

    /*method return 1 when number of factors is even number and -1 when number of factors is odd number*/
    public int numOfFactors(int n) {
        int count = 1;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        if (count % 2 == 0) {
            return 1;
        } else {
            return -1;
        }
    }

}