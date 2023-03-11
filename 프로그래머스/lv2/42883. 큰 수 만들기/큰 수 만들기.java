class Solution {

    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int index = 0;

        for (int i = 0; i < number.length() - k; i++) {
            int max = 0;
            for (int j = index; j <= i + k; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    index = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}
