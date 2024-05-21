#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int n, int m, vector<int> section) {
    int answer = 0;
    
    int painted_idx = section[0] + m - 1;
    answer++;
    
    for(int i = 1 ; i < section.size() ; i++){
        if(section[i] > painted_idx){
            painted_idx = section[i] + m - 1;
            answer++;            
        }
    }
    
    
    
    return answer;
}