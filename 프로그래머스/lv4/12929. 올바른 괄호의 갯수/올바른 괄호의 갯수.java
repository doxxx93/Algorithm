import java.util.Stack;

class Solution {

    public int solution(int n) {
        int answer = 0;

        Stack<P> stack = new Stack<>();
        stack.push(new P(0, 0)); // 괄호의 개수 0 개부터 시작
        while (!stack.isEmpty()) {

            P p = stack.pop();

            if (p.open > n) {
                continue;
            }
            if (p.open < p.close) {
                continue;
            }

            if (p.open + p.close == 2 * n) {
                answer++;
                continue;
            }

            stack.push(new P(p.open + 1, p.close));
            stack.push(new P(p.open, p.close + 1));

        }

        return answer;
    }

    class P {

        int open, close;

        public P(int open, int close) {
            this.open = open;
            this.close = close;
        }
    }
}