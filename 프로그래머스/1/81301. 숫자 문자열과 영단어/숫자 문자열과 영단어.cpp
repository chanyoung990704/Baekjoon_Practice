#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = 0;
    vector<string> eng_num = {"zero", "one", "two", "three", "four", "five",
                             "six", "seven", "eight", "nine"};
    

    for(int i = 0 ; i < eng_num.size() ; i++) {
        
        size_t pos = s.find(eng_num[i]);
        
        while(pos != string::npos){
            s.replace(pos, eng_num[i].size(), to_string(i));
            pos = s.find(eng_num[i], pos + 1);
        }
        
    }
    answer = stoi(s);
    return answer;
}