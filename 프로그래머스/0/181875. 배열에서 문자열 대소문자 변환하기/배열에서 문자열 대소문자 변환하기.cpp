#include <string>
#include <vector>

using namespace std;

vector<string> solution(vector<string> strArr) {
    vector<string> answer;
    for(int i = 0 ; i < strArr.size() ; i++) {
        string& cur = strArr[i];
        // 짝수
        if(i % 2 == 0){
            for(auto& c : cur)
                if(isupper(c))
                    c = tolower(c);
        }
        
        // 홀수
        else{
            for(auto& c : cur)
                if(islower(c))
                    c = toupper(c);
        }
    }
    return strArr;
}