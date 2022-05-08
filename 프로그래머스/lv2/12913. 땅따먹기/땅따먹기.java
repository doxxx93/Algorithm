class Solution {

    int solution(int[][] land) {
        int answer = 0;

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                land[i][j] += getMax(land[i - 1], i, j);
            }
        }
        
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, land[land.length - 1][i]);
        }

        return answer;
    }
    int getMax( int[] beforeRow, int currentRow, int currentCol) {
        int max = 0;
        for (int i = 0; i < 4; i++) {
            if (i == currentCol) {
                continue;
            } else {
                max = Math.max(max, beforeRow[i]);
            }
        }
        return max;
    }
}