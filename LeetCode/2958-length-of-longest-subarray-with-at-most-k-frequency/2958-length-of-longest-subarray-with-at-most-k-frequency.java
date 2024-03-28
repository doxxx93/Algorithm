class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int len = 0;
        int l = 0;
        Map<Integer, Integer> f = new HashMap<>();
        for (int r = 0; r< nums.length; r++){
            f.merge(nums[r],1,Integer::sum);
            while (f.get(nums[r]) > k ){
                f.merge(nums[l], -1 , Integer::sum);
                l++;
            }
            len = Math.max(len, r - l + 1);
        }
        return len;
    }
}