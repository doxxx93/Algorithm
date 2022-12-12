import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        for (String input: babbling){
            for(String word : words) {
                input = input.replace(word, " ");
            }
            if (input.trim().length()==0){
                answer++;
            }
        }
        return answer;
    }
}
