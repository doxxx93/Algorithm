class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int out = -1;
        int left = -1;
        int right = -1;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (cur < minK || cur > maxK) {
                out = i;
            }

            if (cur == minK) {
                left = i;
            }

            if (cur == maxK) {
                right = i;
            }

            int min = Math.min(left, right);
            
            res += Math.max(0, min - out);
        }

        return res;
    }
}
