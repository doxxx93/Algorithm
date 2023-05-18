import java.util.stream.*;

class Solution {

    public int[] solution(int l, int r) {
        int[] numbers = IntStream.rangeClosed(l, r)
            .filter(i -> String.valueOf(i).matches("^[05]+$"))
            .toArray();
        if (numbers.length == 0) {
            return new int[] {-1};
        }
        return numbers;
    }
}