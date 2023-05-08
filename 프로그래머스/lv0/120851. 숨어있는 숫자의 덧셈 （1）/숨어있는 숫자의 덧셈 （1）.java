class Solution {
    public int solution(String my_string) {
        return my_string.chars().filter(i -> ('0'<= i && i <= '9')).map(i -> i - '0').sum();
    }
}