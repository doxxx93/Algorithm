import java.util.HashMap;
import java.util.Map;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] p = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String s : p) {
            map.merge(s, 1, Integer::sum);
        }
        map.remove("");
        for (String s : banned) {
            map.remove(s);
        }
        int max = 0;
        String res = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }
}