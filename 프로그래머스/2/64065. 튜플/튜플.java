import java.util.*;

class Solution {

    public int[] solution(String s) {
        String[] str = s.substring(2, s.length() - 2).split("\\},\\{");
        Arrays.sort(str, Comparator.comparingInt(String::length));

        int[] answer = new int[str.length];
        Set<String> numInAnswer = new HashSet<>();
        for (int i = 0; i < str.length; i++) {
            String[] nums = str[i].split(",");

            for (String num : nums) {
                if (numInAnswer.add(num)) {
                    answer[i] = Integer.parseInt(num);
                    break;
                }
            }
        }
        return answer;
    }
}