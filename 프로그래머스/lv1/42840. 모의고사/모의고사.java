import java.util.*;

class Solution {

    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[][] picks = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int max = 0;
        int[] count = new int[picks.length];
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < picks.length; j++) {
                if (answers[i] == picks[j][i % picks[j].length]) {
                    count[j]++;
                    max = Math.max(max, count[j]);
                }
            }
        }
        
        for (int i = 0; i < 3; i++) {
            if (count[i] == max) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
