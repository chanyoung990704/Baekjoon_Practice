#include <string>
#include <vector>

using namespace std;

string solution(string my_string, string alp) {
    string answer = "";
    size_t pos = my_string.find(alp);
    while(pos != string::npos){
        my_string[pos] = toupper(my_string[pos]);
        pos = my_string.find(alp, pos + 1);
    }
    answer = my_string;
    return answer;
}