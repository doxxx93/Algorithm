class Solution {

    public int solution(int n) {
        if (n < 3) {
            return 1;
        }

        int answer = 1;
        int left = 1;
        int right = 2;
        int sum = left + right;

        while (right < n) {
            if (sum < n) {
                ++right;
                sum += right;
                continue;
            }
            if (sum == n) {
                answer++;
            }
            sum -= left;
            left++;
        }
        return answer;
    }
}