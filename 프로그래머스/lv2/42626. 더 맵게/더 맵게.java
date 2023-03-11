import java.util.*;

class Solution {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Arrays.stream(scoville).forEach(heap::add);
        int answer = 0;
        while (heap.peek() < K) {
            if (heap.size() == 1) {
                return -1;
            }
            int first = heap.poll();
            int second = heap.poll();
            heap.add(first + second * 2);
            answer++;
        }
        return answer;
    }
}
