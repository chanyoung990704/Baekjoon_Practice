#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int solution(vector<string> babbling) {
    int answer = 0;
    vector<string> can_word = {"aya", "ye", "woo", "ma"};
    
    for (string b : babbling) {
        string temp = b;
        
        for (string w : can_word) {
            size_t pos = temp.find(w);
            if (pos != string::npos) {
                temp.replace(pos, w.length(), " ");
            }
        }
        
        temp.erase(remove(temp.begin(), temp.end(), ' '), temp.end());
        
        if (temp.empty()) {
            answer++;
        }
    }
    
    return answer;
}