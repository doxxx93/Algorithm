import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // 각 개수에 따른 가능한 수를 저장할 배열
        ArrayList<Integer>[] dp = new ArrayList[9];
        for (int i = 1; i <= 8; i++) {
            dp[i] = new ArrayList<>();
        }
        for(int i =1; i<=8; i++){
            dp[i].add(Integer.parseInt(Integer.toString(N).repeat(i)));
        }
        for(int i =1; i<=8; i++){
            for(int j =1; j<i; j++){
                for(int k =0; k<dp[j].size(); k++){
                    for(int l =0; l<dp[i-j].size(); l++){
                        dp[i].add(dp[j].get(k) + dp[i-j].get(l));
                        dp[i].add(dp[j].get(k) - dp[i-j].get(l));
                        dp[i].add(dp[j].get(k) * dp[i-j].get(l));
                        if(dp[i-j].get(l) != 0){
                            dp[i].add(dp[j].get(k) / dp[i-j].get(l));
                        }
                    }
                }
            }
        }
        int answer = -1;
        for(int i =1; i<=8; i++){
            if(dp[i].contains(number)){
                answer = i;
                break;
            }
        }
        return answer;
    }
}