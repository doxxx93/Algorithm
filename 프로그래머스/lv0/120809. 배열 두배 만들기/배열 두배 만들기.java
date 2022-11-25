import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> result = new ArrayList<>(); 
        for (int number : numbers) {
            result.add(number * 2);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
