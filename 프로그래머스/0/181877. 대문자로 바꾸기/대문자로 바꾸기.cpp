#include <string>
#include <vector>

using namespace std;

string solution(string myString) {
    string answer = "";
    for(auto& c : myString)
        if(islower(c))
            c = toupper(c);
    
    answer = myString;
    return answer;
}