class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                ans += 2;
            } else {
                set.add(c);
            }
        }
    
        if (set.isEmpty()){
            return ans;
        }
        return ans + 1;
    }
}