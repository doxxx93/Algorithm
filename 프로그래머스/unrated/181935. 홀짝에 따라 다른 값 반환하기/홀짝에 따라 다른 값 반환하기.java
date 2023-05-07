import java.util.stream.*;

class Solution {
    public int solution(int n) {
        if(n % 2 == 1){
            return IntStream.rangeClosed(1,n).filter(i -> i%2==1).sum();
        }
        return IntStream.rangeClosed(1,n).filter(i -> i%2==0).map(i-> i*i).sum();
    }
}