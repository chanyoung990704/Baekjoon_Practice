#include <string>
#include <vector>

using namespace std;

string solution(string myString, string pat) {
    string answer = "";
    size_t pos = myString.find(pat);
    size_t end = 0;
    
    while(pos != string::npos){
        end = pos;
        pos = myString.find(pat, pos + 1);
    }
    
    answer = myString.substr(0, end + pat.size());
    return answer;
}