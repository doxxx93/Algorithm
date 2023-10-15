/*
기사: 1 ~ number
약수 개수에 해당하는 공격력을 가진 무기

*/

import java.util.*;

class Solution {

    static List<Integer> divisorCount = new ArrayList<>();

    public int solution(int number, int limit, int power) {
        divisorCount.add(0);
        countNumberOfDivisors(number, limit, power);
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            if (divisorCount.get(i) > limit) {
                answer += power;
                continue;
            }
            answer += divisorCount.get(i);
        }

        return answer;
    }

    private void countNumberOfDivisors(int n, int limit, int power) {
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) {
                    count++;
                } else if (i % j == 0) {
                    count += 2;
                }
            }
            divisorCount.add(count);
        }
    }
}

