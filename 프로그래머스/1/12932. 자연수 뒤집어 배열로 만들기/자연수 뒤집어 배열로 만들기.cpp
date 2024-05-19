#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(long long n) {
    vector<int> answer;
    
    string str_num = to_string(n);
    for(auto& c : str_num)
        answer.push_back(c - '0');
    
    reverse(answer.begin(), answer.end());
    
    return answer;
}