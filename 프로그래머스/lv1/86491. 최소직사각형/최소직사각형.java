import java.util.*;

class Solution {

    public int solution(int[][] sizes) {
        int w = Arrays.stream(sizes).mapToInt(size -> Math.max(size[0], size[1])).max().getAsInt();
        int h = Arrays.stream(sizes).mapToInt(size -> Math.min(size[0], size[1])).max().getAsInt();
        return w * h;
    }
}
