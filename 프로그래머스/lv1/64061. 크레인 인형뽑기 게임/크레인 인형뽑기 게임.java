import java.util.Stack;

class Solution {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        // 바구니 스택 선언
        Stack<Integer> stack = new Stack<>();
        // 바구니에 0 저장
        stack.push(0);

        // moves 배열 순회
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                // 격자의 맨 위 숫자
                if (board[j][move - 1] != 0) {
                    // 바구니의 숫자와 비교 해서 동일하면 바구니에서 제거
                    if (stack.peek() == board[j][move - 1]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        // 동일하지 않으면 바구니에 저장
                        stack.push(board[j][move - 1]);
                    }
                    // 격자의 맨 위 숫자 0으로 
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }

}