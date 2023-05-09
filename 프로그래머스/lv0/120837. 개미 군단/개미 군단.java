class Solution {
    public int solution(int hp) {
        int count = hp / 5;
        hp %= 5;
        count += hp / 3;
        return count + hp %3;
    }
}