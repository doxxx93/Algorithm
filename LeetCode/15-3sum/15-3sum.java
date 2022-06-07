import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);

        for (int left = 0; left < nums.length - 2; left++) {
            if (left == 0 || (left > 0 && nums[left] != nums[left - 1])) {
                int mid = left + 1;
                int right = nums.length - 1;
                int sum = 0 - nums[left];
                while (mid < right) {
                    if (nums[mid] + nums[right] == sum) {
                        List<Integer> ref = new ArrayList<>();
                        ref.add(nums[left]);
                        ref.add(nums[mid]);
                        ref.add(nums[right]);
                        answer.add(ref);
                        while (mid < right && nums[mid] == nums[mid + 1]) {
                            mid++;
                        }
                        while (mid < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        mid++;
                        right--;
                    } else if (nums[mid] + nums[right] < sum) {
                        mid++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return answer;
    }
}