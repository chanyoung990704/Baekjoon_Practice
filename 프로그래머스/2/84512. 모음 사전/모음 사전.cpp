#include <string>
#include <vector>
#include <map>

using namespace std;

void backtracking(vector<char>& alphabet, string& result, int& cnt, map<string, int>& m) {
    
    if(result.size() > 5)
        return;
    
    if(!result.empty()) {
        // 개수 증가 후 맵 삽입
        cnt++;
        m[result] = cnt;
    }
    
    for(int i = 0 ; i < alphabet.size() ; i++){
        result.push_back(alphabet[i]);
        backtracking(alphabet, result, cnt, m);
        result.pop_back();
    }
    
    return;
}

int solution(string word) {
    
    vector<char> alphabet = {'A', 'E', 'I', 'O', 'U'};
    map<string, int> m;
    string result = "";
    int cnt = 0;
    backtracking(alphabet, result, cnt, m);
    
    return m[word];
    
    
}