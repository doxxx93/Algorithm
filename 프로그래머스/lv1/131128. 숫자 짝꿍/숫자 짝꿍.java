import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] xArr = new int[10];
        for (char c : X.toCharArray()){
            int num = c - '0';
            xArr[num]++;
        }
        
        int[] yArr = new int[10];
        for (char c : Y.toCharArray()){
            int num = c - '0';
            yArr[num]++;
        }
        
        int[] res = new int[10];
        int cSum = 0;
        int sum = 0;
        for(int i = 0; i < 10; i++){
            res[i] = Math.min(xArr[i], yArr[i]);
            cSum += res[i] * i;
            sum += res[i]; 
        }
        
        if (sum == 0){
            return "-1";
        }
        
        if (cSum == 0){
            return "0";
        }
        
        
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--){
            while(res[i]--> 0){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}