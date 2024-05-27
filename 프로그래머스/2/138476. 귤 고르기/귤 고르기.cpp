#include <string>
#include <vector>
#include <unordered_set>
#include <algorithm>

using namespace std;

int solution(int k, vector<int> tangerine) {
    unordered_set<int> tan_set;
    int max_val = *max_element(tangerine.begin(), tangerine.end());
    vector<int> num_cnt(max_val + 1, 0);
    for(auto& n : tangerine){
        num_cnt[n]++;
        tan_set.insert(n);
    }
    
    sort(num_cnt.begin(), num_cnt.end(), greater<>());
    
    int h = 0;
    int total = 0;
    
    for(int i = 0 ; i < num_cnt.size() ; i++){
        
        int cur = num_cnt[i];
        
        if(total + cur >= k){
            h++;
            break;
        }else{
            total += cur;
        }
        
        h++;
    }
    
    return h;
}