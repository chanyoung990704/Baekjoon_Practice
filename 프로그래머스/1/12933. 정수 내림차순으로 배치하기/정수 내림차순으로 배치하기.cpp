#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    
    string str_num = to_string(n);
    sort(str_num.begin(), str_num.end(), greater<>());
    
    answer = stoll(str_num);
    
    return answer;
}