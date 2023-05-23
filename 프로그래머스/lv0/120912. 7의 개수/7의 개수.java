class Solution {

    public int solution(int[] array) {
        int count = 0;
        for (int x : array) {
            int tmp = 0;
            while (x > 0) {
                if (x % 10 == 7) {
                    tmp++;
                }
                x /= 10;
            }
            count += tmp;
        }
        return count;
    }
}