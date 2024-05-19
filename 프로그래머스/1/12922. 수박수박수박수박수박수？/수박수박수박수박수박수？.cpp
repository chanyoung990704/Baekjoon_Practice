#include <string>
#include <vector>

using namespace std;

string solution(int n) {
    string answer = "";
    int idx = 0;
    while(idx < n){
        if(idx % 2 == 0){
            answer.append("수");
        }else{
            answer.append("박");
        }
        idx++;
    }
    
    return answer;
}