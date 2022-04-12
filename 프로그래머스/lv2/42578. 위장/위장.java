import java.util.HashMap;
import java.util.Map;

class Solution {

    public int solution(String[][] clothes) {
        Map<String, Integer> counts = new HashMap<>();

        for (String[] clothe : clothes) {
            String type = clothe[1];
            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }

        int answer = 1;
        for (Integer count : counts.values()) {
            answer *= count + 1;
        }
        answer -= 1;

        return answer;
    }
}
