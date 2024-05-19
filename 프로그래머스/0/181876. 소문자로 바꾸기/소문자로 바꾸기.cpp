#include <string>
#include <vector>

using namespace std;

string solution(string myString) {
    string answer = "";
    for(auto& c : myString){
        if(isupper(c))
            c = tolower(c);
    }
    answer = myString;
    return answer;
}