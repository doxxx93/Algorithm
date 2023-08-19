class Solution {
    public int solution(String my_string, String is_suffix) {
        if ( my_string.lastIndexOf(is_suffix) == my_string.length() - is_suffix.length() && my_string.length() >= is_suffix.length() ) {
            return 1;
        }
        return 0;
    }
}