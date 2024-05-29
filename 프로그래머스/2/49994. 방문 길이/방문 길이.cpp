#include <vector>
#include <string>
#include <algorithm>
#include <set>
using namespace std;

int solution(string dirs) {
    int answer = 0;
    
    set<pair<pair<int,int>, pair<int,int>>> visited;
    
    int cur_y = 0;
    int cur_x = 0;
    
    for(auto& dir : dirs) {
        int next_y = cur_y;
        int next_x = cur_x;
        
        if(dir == 'U')
            next_y++;
        else if(dir == 'D')
            next_y--;
        else if(dir == 'R')
            next_x++;
        else if(dir == 'L')
            next_x--;
        
        if(next_y < -5 || next_y > 5 || next_x < -5 || next_x > 5)
            continue;
        
        pair<int, int> start = make_pair(cur_y, cur_x);
        pair<int, int> end = make_pair(next_y, next_x);
        
        visited.insert(make_pair(start, end));
        visited.insert(make_pair(end, start));
        
        cur_y = next_y;
        cur_x = next_x;
        
    }
    
    answer = visited.size() / 2;
    
    return answer;
}