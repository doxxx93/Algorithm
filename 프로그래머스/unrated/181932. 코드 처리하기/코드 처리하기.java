class Solution {
    public String solution(String code) {
        boolean mode = false;
        String ans ="";
        for(int i = 0; i < code.length(); i++){
            char c = code.charAt(i);
            if(c == '1'){
                mode = !mode;
                continue;
            }
            if (mode){
                if( i %2==1){
                    ans += code.charAt(i);
                }
            } else{
                if(i%2==0){
                    ans += code.charAt(i);
                }
            }
        }
        if (ans.length() == 0){
            return "EMPTY";
        }
        return ans;
    }
}