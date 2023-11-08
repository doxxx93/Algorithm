import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> res = new HashSet<>();

        int size = 1;
        while (size <= elements.length) {
            for (int i = 0; i < elements.length; i++) {
                int sum = 0;
                for (int j = i; j < i + size; j++) {
                    sum += elements[j % elements.length];
                }
                res.add(sum);
            }
            size++;
        }

        return res.size();
    }
}
