class Solution {
    public int solution(String[] s1, String[] s2) {
        int count = 0;
        for(String x : s1){
            for(String y : s2){
                if (x.equals(y)){
                    count++;
                }
            }
        }
        return count;
    }
}