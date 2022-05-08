import java.util.Arrays;
import java.util.stream.Stream;

class Solution {
    public String solution(String s) {
        String answer = "";

        int[] numbers = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);

        answer += numbers[0] + " "; 
        answer += numbers[numbers.length - 1];
        return answer;
    }
}