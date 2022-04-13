class Solution {

    public boolean solution(int x) {
        boolean answer = isHarshad(x);
        
        return answer;
    }

    public boolean isHarshad(int x) {
        int sum = 0;
        int temp = x;

        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }

        return (x % sum == 0);
    }


}