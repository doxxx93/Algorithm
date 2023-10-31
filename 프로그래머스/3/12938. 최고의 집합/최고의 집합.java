class Solution {

    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }
        int[] result = new int[n];
        int fill = s / n;
        int remainder = s % n;

        for (int i = 0; i < n; i++) {
            result[i] = fill + (i < n - remainder ? 0 : 1);
        }

        return result;
    }
}