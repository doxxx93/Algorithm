import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            for(int j = i; j>=0 ; j--){
                if(i == j){
                    continue;
                }
                if(s.charAt(j)== c){
                    answer[i] = i - j;
                    break;
                }
            }
        }
        for(int i =0; i<answer.length;i++){
            if(answer[i]==0){
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}