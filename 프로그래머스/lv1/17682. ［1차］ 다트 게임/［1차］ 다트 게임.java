class Solution {

    public int solution(String dartResult) {
        int answer = 0;

        String temp = "";
        int[] score = new int[3];
        int idx = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            // 1-1. 문자열의 각 문자에 따라 조건 처리.
            switch (dartResult.charAt(i)) {
                // 1-2. *인 경우는 자신과 이전의 점수 *2, idx는 S,D,T 처리 후 증가하기 때문에 idx-1, idx-2 후 *2    
                case '*':
                    score[idx - 1] *= 2;
                    if (idx > 1) {
                        score[idx - 2] *= 2;
                    }
                    break;
                // 1-3. #은 자신의 점수를 음수로 만든다.                 
                case '#':
                    score[idx - 1] *= -1;
                    break;
                // 1-4. S는 1제곱, 다음 점수를 위해 idx를 증가시키고 정수를 저장하는 temp를 초기화.    
                case 'S':
                    score[idx] = (int) Math.pow(Integer.parseInt(temp), 1);
                    idx++;
                    temp = "";
                    break;
                // 1-5. D는 2제곱, 다음 점수를 위해 idx를 증가시키고 정수를 저장하는 temp를 초기화.    
                case 'D':
                    score[idx] = (int) Math.pow(Integer.parseInt(temp), 2);
                    idx++;
                    temp = "";
                    break;
                // 1-6. T는 3제곱, 다음 점수를 위해 idx를 증가시키고 정수를 저장하는 temp를 초기화.                   
                case 'T':
                    score[idx] = (int) Math.pow(Integer.parseInt(temp), 3);
                    idx++;
                    temp = "";
                    break;
                // 1-7. 그 외의 정수들은 temp 변수에 저장해 둔다.    
                default:
                    temp += String.valueOf(dartResult.charAt(i));
                    break;
            }
        }
        for (int i = 0; i < score.length; i++) {
            answer += score[i];
        }

        return answer;
    }
}