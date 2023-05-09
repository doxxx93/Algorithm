class Solution {
    public int solution(String myString, String pat) {
        char[] chars = myString.toCharArray();
        for(int i = 0 ; i < chars.length ; i++){
            if (chars[i] == 'A'){
                chars[i] = 'B';
            } else{
                chars[i] = 'A';
            }
        }
        System.out.println(new String(chars));
        return new String(chars).contains(pat)? 1: 0;
    }
}