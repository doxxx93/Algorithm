import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        for (int i = 0; i < sizes.length; i++) {
            Arrays.sort(sizes[i]);
        }
        answer = getMax(sizes)[0] * getMax(sizes)[1];
        return answer;
    }

    /*method return arrays[i][0]'s max and arrays[i][1]'s max*/
    public int[] getMax(int[][] arrays) {
        int[] answer = new int[2];
        for (int i = 0; i < arrays.length; i++) {
            answer[0] = Math.max(answer[0], arrays[i][0]);
            answer[1] = Math.max(answer[1], arrays[i][1]);
        }
        return answer;
    }



}