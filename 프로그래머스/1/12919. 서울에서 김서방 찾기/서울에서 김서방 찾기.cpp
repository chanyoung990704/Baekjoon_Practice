#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<string> seoul) {
    string answer = "";
    
    auto iter = find(seoul.begin(), seoul.end(), "Kim");
    int idx = iter - seoul.begin();
    
    answer.append("김서방은 ");
    answer.append(to_string(idx));
    answer.append("에 있다");
    
    return answer;
}