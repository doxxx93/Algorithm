class Solution {

    public int solution(int n) {
        return lcm(6, n) / 6;
    }

    private int lcm(int i, int n) {
        return i * n / gcd(i, n);
    }

    private int gcd(int i, int n) {
        if (n == 0) {
            return i;
        }
        return gcd(n, i % n);
    }
}
