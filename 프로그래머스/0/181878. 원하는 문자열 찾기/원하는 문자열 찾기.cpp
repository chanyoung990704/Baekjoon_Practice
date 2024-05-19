#include <string>
#include <vector>

using namespace std;

int solution(string myString, string pat) {
    int answer = 0;
    // 사이즈 비교
    if(myString.size() < pat.size())
        return answer;
    
    // 모든 단어 소문자 치환
    for(auto& c : myString)
        if(isupper(c))
            c = tolower(c);
    for(auto& c : pat)
        if(isupper(c))
            c = tolower(c);
    
    // 찾기
    if(myString.find(pat) != string::npos)
        answer = 1;
    return answer;
}