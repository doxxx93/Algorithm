import java.util.*;

class Solution {

    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] str = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (str[0].equals("0")) {
            return "0";
        }
        for (String s : str) {
            answer.append(s);
        }
        return answer.toString();
    }
}
