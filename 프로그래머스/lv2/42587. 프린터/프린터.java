import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int priority : priorities) {
            pq.add(priority);
        }
        while(!pq.isEmpty()){
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
        return answer;
    }
}