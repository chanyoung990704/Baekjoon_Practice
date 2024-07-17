import java.util.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {        
        int hp = health;
        int cur = 0;
        
        for(int[] attack : attacks) {
            
            // 현재부터 몬스터 만나기 전까지 체력
            int stages = (attack[0] - 1) - cur;
            hp += (stages * bandage[1]);
            // 추가 체력
            if(stages >= bandage[0])
                hp += (stages / bandage[0]) * bandage[2];
            
            if(hp > health)
                hp = health;
            
            // 몬스터한테 공격받음
            hp -= attack[1];
            
            // 체력이 없는 경우
            if(hp <= 0)
                return -1;
            
            cur = attack[0];
            
            
        }
        
        return hp;
    }
}