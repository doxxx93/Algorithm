class Solution {

    public int solution(String word) {
        int answer = 0;
        int max = 3905;
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (word.charAt(i - 1) == vowels[j]) {
                    answer += ((max / Math.pow(5, i)) * j) + 1;
                }
            }
        }
        return answer;
    }
}
