import java.util.*;
import java.util.stream.*;

class Solution {

    public int solution(String numbers) {
        List<Integer> list = numbers.chars().mapToObj(c -> c - '0').collect(Collectors.toList());
        Set<Integer> set = new HashSet<>();
        permutation(list, set, 0, numbers.length());
        return set.size();
    }

    private void permutation(List<Integer> list, Set<Integer> set, int i, int length) {
        if (i == length) {
            return;
        }
        for (int j = i; j < length; j++) {
            Collections.swap(list, i, j);
            int num = listToNum(list, i);
            if (isPrime(num)) {
                set.add(num);
            }
            permutation(list, set, i + 1, length);
            Collections.swap(list, i, j);
        }
    }

    private boolean isPrime(int num) {
        if (num < 4) {
            return num > 1;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    private int listToNum(List<Integer> list, int i) {
        int num = 0;
        for (int j = 0; j <= i; j++) {
            num = num * 10 + list.get(j);
        }
        return num;
    }
}
