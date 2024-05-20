#include <string>
#include <vector>
#include <queue>
#include <algorithm>
#include <math.h>

using namespace std;

int solution(int n) {
    int answer = 0;
    
    vector<int> v;
    
    while(n > 0) {
        v.push_back(n % 3);
        n /= 3;
    }
    
    reverse(v.begin(), v.end());
    
    for(int i = 0 ; i < v.size() ; i++) {
        answer += (v[i] * pow(3, i));
    }
    
    
    
    return answer;
}