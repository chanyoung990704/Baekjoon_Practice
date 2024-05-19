#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(string s) {
    int answer = 0;
    
    string parse_s = s.substr(1, s.size() - 1);
    answer = stoi(parse_s);
    if(s[0] == '-'){
        answer *= -1;
    }
    else if(s[0] == '+'){

    }else{
        answer = stoi(s.substr(0, s.size()));
    }
    return answer;
}