class Solution {
    public int solution(int[] num_list) {
        var even = "";
        var odd = "";
        for( int x : num_list){
            if (x%2==0){
                even += x;
            } else {
                odd += x;
            }
        }
        return Integer.parseInt(even) + Integer.parseInt(odd);
    }
}