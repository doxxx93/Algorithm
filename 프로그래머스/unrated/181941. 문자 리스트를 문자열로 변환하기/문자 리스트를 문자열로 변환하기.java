import java.util.*;

class Solution {
    public String solution(String[] arr) {
        return Arrays.stream(arr).reduce((a,b) -> a+b).get();
    }
}