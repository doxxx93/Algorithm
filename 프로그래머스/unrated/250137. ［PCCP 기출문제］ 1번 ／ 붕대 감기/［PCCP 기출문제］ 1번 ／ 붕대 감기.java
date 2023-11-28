/*
int[] bandage는 [시전 시간, 초당 회복량, 추가 회복량]

int health는 최대 체력

int[][] attacks은 
    attacks[i]는 [공격 시간, 피해량] 형태의 길이가 2인 정수 배열입니다.
*/
import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 연속 성공 시간
        int cont = 0;
        // 최대 체력
        int maxHealth = health;
        // 공격 순서
        int aIndex = 0;
        
        for (int time = 1; time <= attacks[attacks.length -1][0]; time++) {
            int[] attack = attacks[aIndex];
            // 공격
            if (attack[0] == time) {
                health -= attack[1];
                aIndex++;
                cont = 0;
                if ( health <= 0 ){
                    return -1;
                }
                continue;
            }
            // 공격 아님
            health = Math.min(health + bandage[1], maxHealth);
            cont++;
            if (cont == bandage[0]){
                cont = 0;
                health = Math.min(health + bandage[2], maxHealth);
            }
        }
        return health;
    }
}