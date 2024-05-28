#include <string>
#include <vector>
#include <deque>
#include <algorithm>

using namespace std;

int solution(int cacheSize, vector<string> cities) {
    int answer = 0;
    
    // 전체 소문자 변환
    for(auto& city : cities){
        transform(city.begin(), city.end(), city.begin(), ::tolower);
    }
    
    // 캐시가 0이면
    if(cacheSize == 0)
        return 5 * cities.size();
    
    int cache_hit = 1;
    int cache_miss = 5;
    int total_time = 0;
    
    deque<string> dq;
    
    for(auto& city : cities){
        auto it = find(dq.begin(), dq.end(), city);
        
        if(it != dq.end()) {
            // 캐시 히트
            total_time += cache_hit;
            dq.erase(it);
            dq.push_back(city);
        } else {
            // 캐시 미스
            total_time += cache_miss;
            if(dq.size() == cacheSize) {
                dq.pop_front();
            }
            dq.push_back(city);
        }
    }
    
    answer = total_time;
    return answer;
}