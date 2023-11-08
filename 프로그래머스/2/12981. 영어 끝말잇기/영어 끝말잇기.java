import java.util.*;

class Solution {

    public int[] solution(int n, String[] words) {
        Set<String> wordsSet = new HashSet<>();
        wordsSet.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)
                || !wordsSet.add(words[i])) {
                return new int[]{i % n + 1, i / n + 1};
            }
        }
        
        return new int[]{0, 0};
    }
}