class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int len = 0;
        int l = -1;
        Map<Integer, Integer> f = new HashMap<>();
        for (int r = 0; r< nums.length; r++){
            f.merge(nums[r],1,Integer::sum);
            while (f.get(nums[r]) > k ){
                l++;
                f.merge(nums[l], -1 , Integer::sum);
            }
            len = Math.max(len, r - l);
        }
        return len;
    }
}