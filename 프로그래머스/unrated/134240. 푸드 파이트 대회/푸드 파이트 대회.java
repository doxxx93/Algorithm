import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i = 1; i < food.length; i++){
            for(int j = 0; j < food[i]/2; j++){
                sb.append(i);
                sb2.append(i);
            }
        }
        return sb.append(0).append(sb2.reverse()).toString();
    }
}