#include <string>
#include <vector>

using namespace std;

void change2(int num, string& result) {
    if(num == 1){
        result.push_back('1');
        return;
    }
    
    change2(num / 2, result);
    result.push_back(num % 2 + '0');
}

vector<int> solution(string s) {

    int cnt = 0;
    int deleted = 0;
    
    while(s != "1") {
        // 이진 변환 시작
        cnt++;
        // 0 제거
        string ns = "";
        for(char c : s)
            if(c == '1')
                ns += c;
        deleted += s.size() - ns.size();
        // 길이를 2진법으로 수정
        string nss = "";
        change2(ns.size(), nss);
        
        s = nss;
    }
    
    vector<int> answer;
    answer.push_back(cnt);
    answer.push_back(deleted);
    
    return answer;
    
}