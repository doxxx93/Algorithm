class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // 음수와 0은 무시하고, 양의 정수만 고려
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1; // 음수와 0은 n+1로 변경하여 무시
            }
        }
        
        // 양의 정수만 고려하여 해당 인덱스에 음수로 표시
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        
        // 가장 작은 양의 정수 찾기
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        
        // 모든 양의 정수가 포함된 경우, 다음 양의 정수는 n + 1
        return n + 1;
    }
}