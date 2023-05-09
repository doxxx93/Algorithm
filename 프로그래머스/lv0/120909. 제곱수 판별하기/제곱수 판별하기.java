import java.util.stream.*;

class Solution {
    public int solution(int n) {
        return IntStream.rangeClosed(1,1000).anyMatch(i-> i * i ==n)?1:2;
    }
}