import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(sol.solution(progresses, speeds)));
        int[] progresses2 = {93, 30, 55};
        int[] speeds2 = {1, 30, 5};
        System.out.println(Arrays.toString(sol.solution(progresses2, speeds2)));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();

        int[] needDays = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                needDays[i] = (100 - progresses[i]) / speeds[i];
            } else {
                needDays[i] = (100 - progresses[i]) / speeds[i] + 1;
            }
        }
        int tmp = needDays[0];
        for (int i = 1; i < needDays.length; i++) {
            if (needDays[i] < tmp) {
                needDays[i] = tmp;
            } else {
                tmp = needDays[i];
            }
        }
        int count = 1;
        for (int i = 0; i < needDays.length; i++) {
            if (i == 0) {
                continue;
            }
            if (needDays[i] == needDays[i - 1]) {
                count++;
            } else {
                result.add(count);
                count = 1;
            }
            if (i == needDays.length - 1) {
                result.add(count);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}