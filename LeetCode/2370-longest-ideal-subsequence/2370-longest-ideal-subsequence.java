class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        for (char c : s.toCharArray()) {
            int curr = 0;
            int start = Math.max(0, c - 'a' - k);
            int end = Math.min(25, c - 'a' + k);
            for (int i = start; i <= end; i++) {
                curr = Math.max(curr, dp[i]);
            }
            dp[c - 'a'] = curr + 1;
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        return max;
    }
}