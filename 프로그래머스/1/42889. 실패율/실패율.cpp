#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(pair<double, int> a, pair<double, int> b){
    if(a.first == b.first){
        return a.second < b.second;
    }
    
    return a.first > b.first;
}

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    
    vector<int> nums(N + 1, 0);
    for(auto& s : stages)
        if(s <= N)
            nums[s]++;
    
    int total = stages.size();
    
    vector<pair<double, int>> v; // 실패율 stage    
    
    for(int i = 1 ; i <= N ; i++){
        if(total == 0){
            v.push_back(make_pair(0, i));
            continue;
        }
        
        double fail_p = (double)nums[i] / total;
        v.push_back(make_pair(fail_p, i));
        total -= nums[i];
    }
    
    sort(v.begin(), v.end(), cmp);
    
    for(int i = 0 ; i < v.size() ; i++)
        answer.push_back(v[i].second);
    
    return answer;
}