import java.util.ArrayList;

class Solution {

    public int[] solution(int[] arr, int divisor) {
        int[] zero = {-1};
        int[] answer = divided(arr, divisor);
        if (answer.length == 0) {
            return zero;
        } else {
            return answer;
        }

    }

    public int[] divided(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                answer.add(arr[i]);
            }
        }
        return answer.stream().sorted().mapToInt(i -> i).toArray();
    }
}