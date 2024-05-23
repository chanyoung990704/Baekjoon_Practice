#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    vector<int> v;
    for(int i = 1 ; i <= n ; i++)
        v.push_back(i);
    
    int lo = 0, hi = 0;
    int sum = 0;
    
    while(hi < v.size()) {
        
        sum += v[hi];
        while(sum > n && lo <= hi){
            sum -= v[lo++];
        }
        
        if(sum == n)
            answer++;
        
        hi++;
        
    }
    
    return answer;
}