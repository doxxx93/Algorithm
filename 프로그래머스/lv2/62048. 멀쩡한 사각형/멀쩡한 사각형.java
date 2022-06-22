class Solution {
    public long solution(int w, int h) {
        long answer = (long) w *h;
        int gcd = gcd(w, h);
        answer -= ((w/gcd)+(h/gcd)-1)*gcd;
        return answer;
    }
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}