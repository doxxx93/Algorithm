class Solution {

    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(n, m);
        answer[1] = lcm(n, m);

        return answer;
    }

    /*method return int gcd of int a and int b*/
    public int gcd(int a, int b) {
        int gcd = 1;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        for (int i = 2; i <= min; i++) {
            if (max % i == 0 && min % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    /*method return int lcm of int a and int b*/
    public int lcm(int a, int b) {
        int lcm = a * b / gcd(a, b);
        return lcm;
    }

}