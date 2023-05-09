import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        List<Integer> res = new ArrayList<>();
        for(int[] query : queries){
            int min = 1000010;
            for (int i = query[0]; i <= query[1]; i++){
                if(arr[i] <= query[2]){
                    continue;
                }
                min = Math.min(arr[i],min);
            }
            if(min == 1000010){
                res.add(-1);
                continue;
            }
            res.add(min);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}