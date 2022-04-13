class Solution {

    /*method return long sum of from 1 to n*/
    public static long sum(int n) {
        return (n * (n + 1)) / 2;
    }

    public long solution(int price, int money, int count) {

        long total = price * sum(count);

        if (total > money) {
            return total - money;
        } else {
            return 0;
        }

    }


}