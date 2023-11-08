class Solution {
    
    static int t = 0;
    static int cnt = 0;
    
    public int[] solution(String s) {
        transe(s);
        return new int[]{t, cnt};
    }
    
    public void transe(String before){
        if (before.equals("1")){
            return;
        }
        t++;
        int size = before.length();
        String noneZero = before.replace("0","");
        cnt += size - noneZero.length();
        
        String after = Integer.toBinaryString(noneZero.length());
        transe(after);
    }
}