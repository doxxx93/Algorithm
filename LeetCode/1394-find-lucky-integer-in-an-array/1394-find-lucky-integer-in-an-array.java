import java.util.TreeMap;

class Solution {
    public int findLucky(int[] arr) {
        TreeMap<Integer, Integer> counts = new TreeMap<>();
        for (int x : arr) {
            counts.merge(x, 1, Integer::sum);
        }
        int lucky = -1;
        for (var entry : counts.entrySet()) {
            if (entry.getKey() == entry.getValue()) {
                lucky = entry.getKey();
            }
        }
        return lucky;
    }
}
