class Solution {

    public int[] solution(int denum1, int num1, int denum2, int num2) {
        int[] answer = new int[2];
        int num = num1 * num2;
        int denum = num1 * denum2 + num2 * denum1;
        int gcd = gcd(denum, num);
        answer[0] = denum / gcd;
        answer[1] = num / gcd;
        return answer;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
