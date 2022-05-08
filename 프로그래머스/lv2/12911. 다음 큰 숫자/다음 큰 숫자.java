class Solution {
    public int solution(int n) {
        return n+(n&-n)+(1<<Integer.bitCount(n)-Integer.bitCount(n+(n&-n)))-1;
    }
}