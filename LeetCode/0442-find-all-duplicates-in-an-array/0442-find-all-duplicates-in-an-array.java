import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : nums) {
            count.merge(x, 1, Integer::sum);
        }
        return count.entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
    }
}