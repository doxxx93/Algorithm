import java.util.*;

class Solution {

    public String[] solution(String[] orders, int[] course) {

        Map<String, Integer> combiMap = new TreeMap<>();

        for (String s : orders) {
            char[] order = s.toCharArray();
            Arrays.sort(order);
            for (int k : course) {
                int[] combi = new int[k];
                combination(order, combi, 0, order.length, k, 0, combiMap);
            }
        }

        List<String> answerList = new ArrayList<>();

        for (int k : course) {
            int max = 0;
            for (String key : combiMap.keySet()) {
                if (key.length() == k) {
                    max = Math.max(max, combiMap.get(key));
                }
            }
            if (max >= 2) {
                for (String key : combiMap.keySet()) {
                    if (key.length() == k && combiMap.get(key) == max) {
                        answerList.add(key);
                    }
                }
            }
        }
        answerList.sort(String::compareTo);
        return answerList.toArray(new String[answerList.size()]);
    }

    public static void combination(char[] arr, int[] combi, int index, int n, int r, int target,
        Map<String, Integer> combiMap) {
        if (r == 0) {
            StringBuilder combiStr = new StringBuilder();
            for (int j : combi) {
                combiStr.append(arr[j]);
            }
            combiMap.merge(combiStr.toString(), 1, Integer::sum);
            return;
        } else if (target == n) {
            return;
        } else {
            combi[index] = target;
            combination(arr, combi, index + 1, n, r - 1, target + 1, combiMap);
            combination(arr, combi, index, n, r, target + 1, combiMap);
        }
    }
}
