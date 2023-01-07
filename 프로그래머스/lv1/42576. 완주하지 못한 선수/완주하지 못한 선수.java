import java.util.*;

class Solution {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> runners = new TreeMap<>();
        for (String runner : participant) {
            runners.put(runner, runners.getOrDefault(runner, 0) + 1);
        }
        for (String runner : completion) {
            runners.put(runner, runners.get(runner) - 1);
            if (runners.get(runner) == 0) {
                runners.remove(runner);
            }
        }
        return runners.keySet().iterator().next();
    }
}
