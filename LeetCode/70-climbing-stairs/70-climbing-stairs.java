class Solution {
    public int climbStairs(int n) {
        int[] t = new int[n + 1];
        t[0] = 1;
        t[1] = 1;
        int rst = df(n, t);
        return rst;
    }

    private int df(int n, int[] t) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (t[n] != 0) {
            return t[n];
        }
        int n1 = df(n - 1, t);
        int n2 = df(n - 2, t);
        t[n] = n2 + n1;
        return n1 + n2;
    }
}