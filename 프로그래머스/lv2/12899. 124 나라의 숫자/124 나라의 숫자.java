class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        String[] arr = {"1", "2", "4"};

        while (n > 0) {
            n -= 1;
            answer.insert(0, arr[n % 3]);
            n /= 3;
        }
        return answer.toString();
    }
}