class Solution {

    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int cur = section[0];
        for (int next : section) {
            if (cur + m <= next) {
                cur = next;
                answer++;
            }
        }

        return answer;
    }
}
