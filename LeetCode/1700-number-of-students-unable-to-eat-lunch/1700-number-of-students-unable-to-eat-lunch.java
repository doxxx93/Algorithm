import java.util.Stack;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stack = new Stack<>();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            stack.push(sandwiches[i]);
        }
        int[] count = new int[2]; // 0 or 1
        for (int student : students) {
            count[student]++;
        }
        while (!stack.isEmpty()) {
            if (count[stack.peek()] > 0) {
                count[stack.pop()]--;
            } else {
                break;
            }
        }
        return stack.size();
    }
}
