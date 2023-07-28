import java.util.stream.*;

class Solution {

    public int solution(String t, String p) {
        return IntStream.range(0, t.length() - p.length() + 1)
            .mapToObj(i -> t.substring(i, i + p.length()))
            .map(Long::parseLong)
            .filter(number -> number <= Long.parseLong(p))
            .collect(Collectors.toList())
            .size();
    }
}