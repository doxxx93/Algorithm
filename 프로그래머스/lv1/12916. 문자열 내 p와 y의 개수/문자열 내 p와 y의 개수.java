class Solution {

    boolean solution(String s) {

        return countPY(s);
    }

    public boolean countPY(String s) {
        if (s.length() == 0) {
            return true;
        }

        s = s.toLowerCase();

        int countP = 0;
        int countY = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p') {
                countP++;
            } else if (s.charAt(i) == 'y') {
                countY++;
            }
        }
        return (countP == countY);
    }
}