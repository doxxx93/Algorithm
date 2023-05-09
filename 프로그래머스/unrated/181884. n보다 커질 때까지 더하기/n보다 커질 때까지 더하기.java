class Solution {
    public int solution(int[] numbers, int n) {
        int sum = 0;
        for (int x : numbers){
            if (sum > n){
                break;
            }
            sum += x;
        }
        return sum;
    }
}