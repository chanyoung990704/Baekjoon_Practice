#include <string>
#include <vector>

using namespace std;

int solution(string myString, string pat) {
    int answer = 0;
    for(char& c : myString) {
        if(c == 'A')
            c = 'B';
        else if(c == 'B')
            c = 'A';
    }
    
    if(myString.find(pat) != string::npos)
        answer = 1;
    
    return answer;
}