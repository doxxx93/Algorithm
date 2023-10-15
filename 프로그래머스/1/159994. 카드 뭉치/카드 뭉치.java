class Solution {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0;
        int index2 = 0;
        for (String cur : goal) {
            if (index1 < cards1.length && cur.equals(cards1[index1])) {
                index1++;
                continue;
            }
            if (index2 < cards2.length && cur.equals(cards2[index2])) {
                index2++;
                continue;
            }
            return "No";
        }
        return "Yes";
    }
}