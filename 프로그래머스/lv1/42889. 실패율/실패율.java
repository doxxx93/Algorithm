import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] stageCount = new int[N];
        Map<Integer, Double> failureMap = new HashMap<>();
        int total = stages.length;

        for (int i = 0; i < total; i++) {
            if (stages[i] == N + 1) {
                continue;
            }
            stageCount[stages[i] - 1]++;
        }

        for (int i = 0; i < stageCount.length; i++) {
            if (total == 0) {
                failureMap.put(i, 0d);
                continue;
            }
            failureMap.put(i, (double) stageCount[i] / (double) total);
            total -= stageCount[i];
        }

        for (int i = 0; i < N; i++) {
            double max = -1;
            int maxkey = 0;

            for (int key : failureMap.keySet()) {
                if (max < failureMap.get(key)) {
                    max = failureMap.get(key);
                    maxkey = key;
                }
            }
            answer[i] = maxkey + 1;
            failureMap.remove(maxkey);
        }

        return answer;
    }
}