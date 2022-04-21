public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
                String num = Integer.toBinaryString(n);
        int count = 0;

        for (char ch : num.toCharArray()) {
            if (ch == '1') {
                count++;
            }
        }
        return count;
    }
        
}