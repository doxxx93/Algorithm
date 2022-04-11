class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count =0;
        for(int number: nums){
            if(number ==1){
                count +=1;
            } else {
                count = 0;
            }
            max = Math.max(count,max);
        }
        return max;
        
    }
}