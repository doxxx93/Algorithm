class Solution {
    public List<String> commonChars(String[] words) {
        int n  = words.length;
        int[] min = new int[26];
        Arrays.fill(min, Integer.MAX_VALUE);
        for (int i = 0 ; i < n; i++) {
            int[] tmp = new int[26];
            for (char c : words[i].toCharArray()) {
                tmp[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                min[j] = Math.min(min[j], tmp[j]);
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0 ; i< min.length; i++) {
            for (int j = 0 ; j < min[i]; j++) {
                res.add(String.valueOf((char) ('a' + i)));
            }
        }

        return res;
    }
}