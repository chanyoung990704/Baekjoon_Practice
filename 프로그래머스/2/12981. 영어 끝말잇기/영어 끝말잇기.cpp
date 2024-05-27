#include <string>
#include <vector>
#include <iostream>
#include <unordered_set>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    vector<int> answer;
    unordered_set<string> words_set;
    int idx = 1;
    int cnt = 0;
    string prev = "";
    for(auto& word : words) {
        
        if(cnt == 0){
            prev = word;
            words_set.insert(word);
            cnt++;
            idx++;
            continue;
        }
        
        // 탈락 조건3
        if(word[0] != prev[prev.size() - 1]){
            cnt /= n;
            cnt++;
            break;
        }
        
        // 탈락 조건 4
        if(words_set.find(word) != words_set.end()){
            cnt /= n;
            cnt++;
            break;
        }
        
        // 성공했을 시
        idx++;
        cnt++;
        prev = word;
        words_set.insert(word);
        
        if(idx > n)
            idx = 1;
        
        
        if(cnt == words.size()){
            idx = 0;
            cnt = 0;
        }
    }
    
    answer.push_back(idx);
    answer.push_back(cnt);

    return answer;
}