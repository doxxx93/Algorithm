import static java.util.stream.Collectors.*;

import java.util.*;

class Solution {

    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                         .collect(groupingBy(clothe -> clothe[1],
                             mapping(clothe -> clothe[0], counting())))
                         .values()
                         .stream()
                         .reduce(1L, (a, b) -> a * (b + 1))
                         .intValue() - 1;
    }
}
