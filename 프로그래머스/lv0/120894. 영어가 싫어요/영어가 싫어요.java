class Solution {

    static String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven",
        "eight", "nine"}; 
    public long solution(String numbers) {
        long answer = 0;
        while (numbers.length() > 0) {
            for (int i = 0; i < Solution.numbers.length; i++) {
                if (numbers.startsWith(Solution.numbers[i])) {
                    answer = answer * 10 + i;
                    numbers = numbers.substring(Solution.numbers[i].length());
                    break;
                }
            }
        }
        return answer;
    }
}