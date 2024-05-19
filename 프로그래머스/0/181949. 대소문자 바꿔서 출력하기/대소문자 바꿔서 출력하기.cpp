#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main(void) {
    string str;
    cin >> str;
    
    // 문자열 순회
    for(int i = 0 ; i < str.size() ; i++) {
        char cur = str[i];
        
        // 현재 단어가 소문자
        if(islower(cur))
            str[i] = toupper(cur);
        // 현재 단어가 대문자
        if(isupper(cur))
            str[i] = tolower(cur);
    }
    
    cout << str;
    return 0;
}