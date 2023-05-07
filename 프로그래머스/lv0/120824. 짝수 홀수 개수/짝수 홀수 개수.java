import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] arr = new int[2];
        arr[0] = (int) Arrays.stream(num_list).filter(i -> i%2==0).count();
        arr[1] = num_list.length - arr[0];
        return arr;
    }
}