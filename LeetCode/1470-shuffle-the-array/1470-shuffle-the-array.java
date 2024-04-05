class Solution {
    public int[] shuffle(int[] nums, int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(nums[i]);
            res.add(nums[i + n]);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}