#include <string>
#include <iostream>
using namespace std;

bool solution(string s)
{

    // 모두 소문자 변환
    for(auto& c : s)
        if(isupper(c))
            c = tolower(c);

    // 개수 새기
    int p_cnt = 0;
    int y_cnt = 0;
    
    for(auto& c : s){
        if(c == 'p')
            p_cnt++;
        if(c == 'y')
            y_cnt++;
    }
    
    return p_cnt == y_cnt;
}