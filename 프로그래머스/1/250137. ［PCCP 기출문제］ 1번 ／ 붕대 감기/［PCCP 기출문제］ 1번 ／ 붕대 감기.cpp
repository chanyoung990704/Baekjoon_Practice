#include <string>
#include <vector>

using namespace std;

int solution(vector<int> bandage, int health, vector<vector<int>> attacks) {

    // 공격 받은 시간 초기화
    int n = attacks.size(); 
    vector<bool> attacked(attacks[n-1][0] + 1, false);
    for(vector<int> v : attacks)
        attacked[v[0]] = true;
    
    int t = 0; // 시간
    int combo = 0; // 연속성공
    int maxHP = health; // hp 최댓값
    bool isPossible = true;
    int monsterIdx = 0;

    // 단계 진행
    for(int i = 1 ; i <= attacks[n-1][0] ; i++) {
        
        combo++;
        
        // 몬스터 공격 구간이라면
        if(attacked[i]) {
            health -= attacks[monsterIdx][1];
            // 피가 0이하면 죽음
            if(health <= 0) {
                isPossible = false;
                break;
            }
            combo = 0;
            monsterIdx++;
            
            continue;
        }
        
        // 콤보 성공 구간이라면
        if(combo == bandage[0]) {
            
            // 체력 회복
            health += bandage[2];
            if(health > maxHP)
                health = maxHP;
            
            // 연속성공 초기화
            combo = 0;
        }
        
        // 회복진행
        health += bandage[1];
        if(health > maxHP)
            health = maxHP;
        
    }
    
    if(isPossible)
        return health;
    else
         return -1;
    
}