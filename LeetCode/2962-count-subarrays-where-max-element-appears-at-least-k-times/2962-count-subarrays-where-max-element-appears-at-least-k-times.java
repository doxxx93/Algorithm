import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        List<Integer> indices = new ArrayList<>();
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                indices.add(i);
            }

            if (indices.size() >= k) {
                count += indices.get(indices.size() - k) + 1;
            }
        }

        return count;
    }
}
