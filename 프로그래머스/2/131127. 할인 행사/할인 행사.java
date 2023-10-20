import java.util.*;

class Solution {

    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        int answer = 0;

        // 10 items in a row in discount
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> temp = new HashMap<>(map);
            for (int j = i; j < i + 10; j++) {
                String item = discount[j];
                temp.computeIfPresent(item, (k, v) -> v - 1);
            }
            if (temp.values().stream().allMatch(v -> v <= 0)) {
                answer++;
            }
        }

        return answer;
    }
}
