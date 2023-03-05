import java.util.*;

class Solution {

    public int solution(int[] topping) {
        int[] prefix = new int[topping.length];
        int[] suffix = new int[topping.length];
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < topping.length; i++) {
            set.add(topping[i]);
            prefix[i] = set.size();
        }
        set.clear();
        for (int i = topping.length - 1; i >= 0; i--) {
            set.add(topping[i]);
            suffix[i] = set.size();
        }
        int count = 0;
        for (int i = 0; i < topping.length - 1; i++) {
            if (prefix[i] == suffix[i + 1]) {
                count++;
            }
        }
        return count;
    }
}
