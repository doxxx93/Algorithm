class Solution {

    int[] check = new int[100001];

    public int solution(int n) {
        Solution sol = new Solution();
        int answer = dp(n);

        return answer;
    }

    public int dp(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        if (check[n] != 0) {
            return check[n];
        }
        check[n] = dp(n - 1) % 1234567 + dp(n - 2) % 1234567;
        return check[n] % 1234567;
    }

}