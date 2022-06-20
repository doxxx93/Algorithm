import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                var twoSum = (long) target - nums[i] - nums[j];
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    var sumLR = nums[left] + nums[right];
                    if (sumLR < twoSum) {
                        left++;
                    } else if (sumLR > twoSum) {
                        right--;
                    } else {
                        if (left > j + 1 && right < nums.length - 1) {
                            if (nums[left] != nums[left - 1] || nums[right] != nums[right + 1]) {
                                answer.add(
                                    Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            }
                        } else {
                            answer.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        }
                        left++;
                        right--;
                    }
                }
            }
        }

        return answer;
    }
}