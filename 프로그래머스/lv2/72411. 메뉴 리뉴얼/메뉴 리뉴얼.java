import java.util.*;

class Solution {

    static Map<String, Integer> combinationMap;

    public String[] solution(String[] orders, int[] course) {
        combinationMap = new TreeMap<>();

        for (String s : orders) {
            char[] order = s.toCharArray();
            Arrays.sort(order);
            for (int r : course) {
                int[] combination = new int[r];
                int n = order.length;
                combination(order, combination, 0, n, r, 0);
            }
        }

        List<String> answerList = new ArrayList<>();

        for (int k : course) {
            int max = 0;
            for (String key : combinationMap.keySet()) {
                if (key.length() == k) {
                    max = Math.max(max, combinationMap.get(key));
                }
            }
            if (max >= 2) {
                for (String key : combinationMap.keySet()) {
                    if (key.length() == k && combinationMap.get(key) == max) {
                        answerList.add(key);
                    }
                }
            }
        }
        answerList.sort(String::compareTo);
        return answerList.toArray(new String[0]);
    }

    public void combination(char[] order, int[] combination, int index, int n, int r, int target) {
        if (r == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i : combination) {
                sb.append(order[i]);
            }
            combinationMap.put(sb.toString(), combinationMap.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        if (target == n) {
            return;
        }
        combination[index] = target;
        combination(order, combination, index + 1, n, r - 1, target + 1);
        combination(order, combination, index, n, r, target + 1);
    }
}
