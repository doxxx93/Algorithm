class Solution {
    public int solution(int[] numbers) {
        int answer = 45-sum(numbers);

        return answer;
    }
    public int sum(int[] numbers) {
        int answer = 0;
        for (int i = 0; i < numbers.length; i++) {
            answer += numbers[i];
        }
        return answer;
    }
    
}