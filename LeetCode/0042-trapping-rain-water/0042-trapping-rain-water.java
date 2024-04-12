class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = height[0];
        suffix[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], height[i]);
            suffix[n - i - 1] = Math.max(suffix[n - i], height[n - i - 1]);
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            total += Math.min(prefix[i], suffix[i]) - height[i];
        }
        return total;
    }
}