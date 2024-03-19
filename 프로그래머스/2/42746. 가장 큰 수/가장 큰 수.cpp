#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(string a, string b) {
    return a + b > b + a;
}

string solution(vector<int> numbers) {
    
    // string 변환
    vector<string> numString;
    for(int number : numbers)
        numString.push_back(to_string(number));
    
    // 정렬
    sort(numString.begin(), numString.end(), cmp);
    
    string ret = "";
    for(string ns : numString)
        ret += ns;
    
    if(ret[0] == '0')
        return "0";
    
    return ret;
}