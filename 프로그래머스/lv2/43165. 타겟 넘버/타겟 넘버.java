class Solution {

    public int solution(int[] numbers, int target) {
        int answer = 0;
        int max = (int) Math.pow(2, numbers.length);
        for (int i = 0; i < max; i++) {
            int sum = 0;
            for (int j = 0; j < numbers.length; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += numbers[j];
                } else {
                    sum -= numbers[j];
                }
            }
            if (sum == target) {
                answer++;
            }
        }
        return answer;
    }
}
