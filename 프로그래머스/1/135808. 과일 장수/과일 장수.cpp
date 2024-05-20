#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int k, int m, vector<int> score) {
    
    int total = 0;
    
    sort(score.begin(), score.end(), greater<int>());
    
    int box_cnt = 0;
    
    for(int i = 0 ; i < score.size() ; i++) {
        box_cnt++;
        
        if(box_cnt == m){
            total += m * score[i];
            box_cnt = 0;
        }
    }
    
    return total;
}