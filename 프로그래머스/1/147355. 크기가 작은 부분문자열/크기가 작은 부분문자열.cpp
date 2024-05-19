#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(string t, string p) {
    int answer = 0;
    
    int t_size = t.size();
    int p_size = p.size();
    
    long long p_num = stoll(p);
    
    for(int i = 0 ; i < t_size - p_size + 1 ; i++){
        string cur = t.substr(i, p_size);
        long long cur_num = stoll(cur);
        if(cur_num <= p_num)
            answer++;
    }
    
    return answer;
}