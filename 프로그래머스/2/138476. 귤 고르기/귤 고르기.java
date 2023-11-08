import java.util.*;
import java.util.Map.*;

class Solution {

    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> tMap = new TreeMap<>(Collections.reverseOrder());
        for (int t : tangerine) {
            tMap.merge(t, 1, Integer::sum);
        }

        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> tMap.get(b) - tMap.get(a));
        q.addAll(tMap.keySet());

        int res = 0;
        while (k > 0) {
            res++;
            int key = q.poll();
            int val = tMap.get(key);
            if (k >= val) {
                k -= val;
            } else {
                break;
            }
        }

        return res;
    }
}
