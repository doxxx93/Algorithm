import java.util.*;

class Solution {

    public int solution(String[] arr) {
        List<Integer> nums = new ArrayList<>();
        List<String> ops = new ArrayList<>();
        Arrays.stream(arr).forEach(s -> {
            if (s.equals("+") || s.equals("-")) {
                ops.add(s);
            } else {
                nums.add(Integer.parseInt(s));
            }
        });
        int[][] max = new int[nums.size()][nums.size()];
        int[][] min = new int[nums.size()][nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            Arrays.fill(max[i], Integer.MIN_VALUE);
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < nums.size(); i++) {
            max[i][i] = nums.get(i);
            min[i][i] = nums.get(i);
        }

        for (int i = 1; i < nums.size(); i++) {
            for (int j = 0; j < nums.size() - i; j++) {
                for (int k = j; k < j + i; k++) {
                    int a = max[j][k];
                    int b = max[k + 1][j + i];
                    int c = min[j][k];
                    int d = min[k + 1][j + i];
                    if (ops.get(k).equals("+")) {
                        max[j][j + i] = Math.max(max[j][j + i], a + b);
                        min[j][j + i] = Math.min(min[j][j + i], c + d);
                    } else {
                        max[j][j + i] = Math.max(max[j][j + i], a - d);
                        min[j][j + i] = Math.min(min[j][j + i], c - b);
                    }
                }
            }
        }
        return max[0][nums.size() - 1];
    }
}
