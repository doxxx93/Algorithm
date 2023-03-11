import java.util.*;

class Solution {

    public long solution(int n, int[] times) {
        long left = 0;
        long right = Arrays.stream(times).max().getAsInt() * (long) n;
        long min = Long.MAX_VALUE;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int time : times) {
                sum += mid / time;
            }

            if (sum >= n) {
                min = Math.min(min, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return min;
    }
}
