class Solution {
    public int solution(int n) {
        int answer = 0;
        /* A natural number n is given as a parameter. After flipping n back and forth in ternary system, complete the solution function to return the number expressed in decimal system again.*/
        String ternary = Integer.toString(n, 3);
        String ternary_flip = "";
        for(int i = ternary.length()-1; i >= 0; i--) {
            ternary_flip += ternary.charAt(i);
        }
        answer = Integer.parseInt(ternary_flip, 3);

        return answer;
    }
}