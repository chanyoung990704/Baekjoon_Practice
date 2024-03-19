#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int getMove(char target) {
    return min(target - 'A', 'Z' - target + 1);
}

int solution(string name) {
    
    int ret = 0;
    
    // 위 아래 최소 move
    for(char target : name)
        ret += getMove(target);
    
    int move = name.size() - 1;
    int len = name.size();
    
    // 좌우 이동
    for(int i = 0 ; i < len ; i++) {
        int next = i + 1;
        while(next < name.size() && name[next] == 'A')
            next++;
        
        move = min(move, i + len - next + min(i, len - next));
    }
 
    ret += move;
    
    return ret;
}