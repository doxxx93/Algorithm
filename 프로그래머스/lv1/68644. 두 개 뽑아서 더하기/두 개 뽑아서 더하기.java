import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        
        for(int i = 0;i<numbers.length;i++){
            for(int j = i+1; j<numbers.length;j++){
                result = numbers[i]+numbers[j];
                set.add(result);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        
        int[] answer = list.stream().mapToInt(i->i).toArray();

        return answer;
    }
}