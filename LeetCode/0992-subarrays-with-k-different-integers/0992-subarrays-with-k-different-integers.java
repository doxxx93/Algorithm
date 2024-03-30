class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return distinct(nums, k) - distinct(nums, k - 1);
    }

    private int distinct(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[n + 1];
        int l = 0;
        int r = 0;
        int count = 0;
        int result = 0;

        while (r < n) {
            if (freq[nums[r]] == 0) {
                count++;
            }
            freq[nums[r]]++;
            r++;

            while (count > k) {
                freq[nums[l]]--;
                if (freq[nums[l]] == 0) {
                    count--;
                }
                l++;
            }

            result += r - l;
        }

        return result;
    }
}
