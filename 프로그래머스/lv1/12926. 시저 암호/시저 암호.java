class Solution {

    public String solution(String s, int n) {
        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                arr[i] = (char) ((s.charAt(i) + n - 'a') % 26 + 'a');
            } else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                arr[i] = (char) ((s.charAt(i) + n - 'A') % 26 + 'A');
            } else {
                arr[i] = s.charAt(i);
            }
        }

        return new String(arr);
    }
}