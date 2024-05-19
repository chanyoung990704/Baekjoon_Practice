#include <string>
#include <vector>

using namespace std;

string solution(vector<string> arr) {
    string answer = "";
    for(auto a : arr)
        answer.append(a);
    return answer;
}