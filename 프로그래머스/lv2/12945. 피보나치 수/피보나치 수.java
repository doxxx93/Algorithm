class Solution {

    int[] check = new int[100001];

    public int solution(int n) {
        return dp(n);
    }

    public int dp(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        if (check[n] != 0) {
            return check[n];
        }
        return (check[n] = dp(n - 1) % 1234567 + dp(n - 2) % 1234567 )% 1234567;
    }
}
