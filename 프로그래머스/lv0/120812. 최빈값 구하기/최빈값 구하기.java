import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int number : array) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        int max = 0;
        int maxKey = 0;
        for (int key : map.keySet()) {
            if (max < map.get(key)) {
                max = map.get(key);
                maxKey = key;
            } else if (max == map.get(key)) {
                maxKey = -1;
            }
        }
        return maxKey;

    }
}