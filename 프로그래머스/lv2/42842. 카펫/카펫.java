class Solution {

    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sum = brown + yellow;
        int width = 0;
        int height = 0;
        for (int i = 1; i <= sum; i++) {
            if (sum % i == 0) {
                width = sum / i;
                height = i;
                if (width >= height && (width - 2) * (height - 2) == yellow) {
                    answer = new int[]{width, height};
                    break;
                }
            }
        }
        return answer;
    }
}
