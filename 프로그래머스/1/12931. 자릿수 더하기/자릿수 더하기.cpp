#include <iostream>

using namespace std;
int solution(int n)
{
    int answer = 0;
    
    string str_num = to_string(n);
    
    for(auto& c : str_num){
        answer += c - '0';
    }

    return answer;
}