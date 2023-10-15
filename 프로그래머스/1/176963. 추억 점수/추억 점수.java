import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> nameYearning = new HashMap<>();
        for(int i = 0 ; i < name.length; i++){
            nameYearning.put(name[i], yearning[i]);
        }
        
        for(String[] shot : photo){
            int sum = 0;
            for(String na : shot){
                sum += nameYearning.getOrDefault(na, 0);
            }
            answer.add(sum);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}