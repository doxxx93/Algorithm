import java.util.*;

class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        int sum = 0;
        int index = 0;
        do {
            answer++;
            if (bridge.size() == bridge_length) {
                sum -= bridge.poll();
            }
            if (index < truck_weights.length && sum + truck_weights[index] <= weight) {
                bridge.add(truck_weights[index]);
                sum += truck_weights[index];
                index++;
                continue;
            }
            bridge.add(0);
        } while (sum != 0);
        return answer;
    }
}
