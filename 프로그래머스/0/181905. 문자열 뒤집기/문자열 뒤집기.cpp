#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string my_string, int s, int e) {
    string answer = "";
    
    string sub_str1 = my_string.substr(0, s);
    string sub_str2 = my_string.substr(s, e - s + 1);
    
    // sub_str2 뒤집기
    reverse(sub_str2.begin(), sub_str2.end());
    
    // replace하기
    my_string.replace(s, e - s + 1, sub_str2);
    
    answer = my_string;
    return answer;
}