/*
사과의 상태는 1점부터 k점까지, 오름차순
사과의 한 상자 가격(m * p): 한 상자 사과 개수(m) * 가장 낮은 사과의 점수(p)
상자 개수를 곱한 최대 이익
*/

import java.util.*;

class Solution {

    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int min = Integer.MAX_VALUE;
        int count = 0;
        int res = 0;
        for (int i = score.length - 1; i >= 0; i--) {
            min = Math.min(score[i], min);
            count++;

            if (count == m) {
                res += min * count;
                count = 0;
            }
        }
        return res;
    }
}