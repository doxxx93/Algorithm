class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod = 1;
        int cnt = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            prod *= nums[r];
            while (prod >= k && l <= r) {
                prod /= nums[l++];
            }
            cnt += r - l + 1;
        }
        return cnt;
    }
}
