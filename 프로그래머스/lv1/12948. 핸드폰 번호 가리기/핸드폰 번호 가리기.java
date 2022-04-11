class Solution {
    public String solution(String phone_number) {
        StringBuffer sb = new StringBuffer();
        sb.append(phone_number);
        int n = phone_number.length();
        
        if(n == 4){
            return phone_number;
        }         
        for(int i =0 ; i < n-4;i++){
            sb.replace(i,i+1,"*");
        }

        
        String answer = sb.toString();
        return answer;
    }
}