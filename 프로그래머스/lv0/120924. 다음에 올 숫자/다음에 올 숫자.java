class Solution {
    public int solution(int[] common) {
        int first = common[0];
        int second = common[1];
        int third = common[2];
        if (second * 2 == first + third){
            return common[common.length-1] + second - first;
        }
        return third * (second / first);
    }
}