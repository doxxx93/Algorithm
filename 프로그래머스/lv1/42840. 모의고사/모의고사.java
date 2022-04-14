import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] pick1 = {1, 2, 3, 4, 5};
        int[] pick2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pick3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] count = new int[3];
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == pick1[i % 5]) count[0]++;
            if(answers[i] == pick2[i % 8]) count[1]++;
            if(answers[i] == pick3[i % 10]) count[2]++;
            
        }
        int max = 0;
        for(int i = 0; i < 3; i++) {
            if(count[i] > max) {
                max = count[i];
            }
            
        }
        for(int i = 0; i < 3; i++) {
            if(count[i] == max) {
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[answer.length - 1] = i + 1;
                
            }
            
        }
        return answer;
            
        
    }
}