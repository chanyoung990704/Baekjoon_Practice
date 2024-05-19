#include <string>
#include <vector>

using namespace std;

bool solution(int x) {
    bool answer = true;
    
    string str_num = to_string(x);
    int v = 0;
    
    for(auto c : str_num)
        v += (c - '0');
    
    if(x % v != 0)
        answer = false;
    
    return answer;
}