class Solution {
    public int solution(int n) {
        int count = 0;
        int i;
        for (i = 1; i * i <= n; i++){
            if (n % i == 0){
                count += 2;
            }
        }
        i--;
        if (n == i *i ){
            return --count;
        }
        return count;
    }
}