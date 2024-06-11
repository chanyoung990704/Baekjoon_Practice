#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int n, vector<int> weak, vector<int> dist) {
    int answer = 1e9;
    
    // weak 길이 확장
    int weak_len = weak.size();
    for(int i = 0 ; i < weak_len ; i++)
        weak.push_back(weak[i] + n);
    
    // weak 첫번째부터 순회
    for(int i = 0 ; i < weak_len ; i++) {
        
        // dist 순열
        do{
            int cnt = 1;
            int limit_dist = weak[i] + dist[cnt - 1];
            
            for(int j = i ; j < i + weak_len ; j++) {
                // 새로운 사람 투입
                if(limit_dist < weak[j]){
                    cnt++;
                    if(cnt > dist.size())
                        break;
                    else
                        limit_dist = weak[j] + dist[cnt - 1];
                }
                
            }
            
            // 사람 체크
            if(cnt <= dist.size())
                answer = min(answer, cnt);
            
        }while(next_permutation(dist.begin(), dist.end()));
        
    }
    
    
    if(answer == 1e9)
        answer = -1;
    
    return answer;
}