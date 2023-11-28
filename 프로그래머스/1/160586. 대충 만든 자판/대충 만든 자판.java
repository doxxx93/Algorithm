import java.util.*;

class Solution {

    public int[] solution(String[] keymap, String[] targets) {
        int[] min = new int[26];
        Arrays.fill(min, Integer.MAX_VALUE);

        for (String s : keymap) {
            for (int i = 0; i < s.length(); i++) {
                int x = s.charAt(i) - 'A';
                min[x] = Math.min(i, min[x]);
            }
        }

        List<Integer> res = new ArrayList<>();

        for (String s : targets) {
            int sum = 0;
            boolean foundInvalidCharacter = false;
            for (int i = 0; i < s.length(); i++) {
                int x = min[s.charAt(i) - 'A'];
                if (x == Integer.MAX_VALUE) {
                    res.add(-1);
                    foundInvalidCharacter = true;
                    break;
                }
                sum += x + 1;
            }
            if (!foundInvalidCharacter) {
                res.add(sum);
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}