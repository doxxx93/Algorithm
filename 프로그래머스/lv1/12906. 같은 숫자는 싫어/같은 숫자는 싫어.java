import java.util.*;

public class Solution {

    public int[] solution(int[] arr) {
        int[] answer = removeContinuousDuplicated(arr);

        return answer;
    }

    /*method remove continuing duplicated number of array arr*/
    public int[] removeContinuousDuplicated(int[] arr) {
        int length = arr.length;
        ArrayList<Integer> temp = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                temp.add(arr[i]);
                j++;
            } else {
                if (arr[i] != arr[i - 1]) {
                    temp.add(arr[i]);
                    j++;
                }
            }
        }
        return temp.stream().mapToInt(i -> i).toArray();
    }


}