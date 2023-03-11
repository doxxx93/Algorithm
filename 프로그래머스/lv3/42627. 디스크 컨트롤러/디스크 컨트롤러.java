import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs,Comparator.comparingInt(o1 -> o1[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o1 -> o1[1]));
        int time = 0;
        int idx = 0;
        while(idx < jobs.length || !pq.isEmpty()){
            while(idx < jobs.length && jobs[idx][0] <= time){
                pq.offer(jobs[idx++]);
            }
            if(!pq.isEmpty()){
                int[] job = pq.poll();
                time += job[1];
                answer += time - job[0];
            }else{
                time = jobs[idx][0];
            }
        }
        return answer/ jobs.length;
    }
}
