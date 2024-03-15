#include <string>
#include <vector>
#include <algorithm>
#include <sstream>

using namespace std;

string solution(string s) {
    
    vector<int> v; // 구분자로 나뉘어진 문자 저장
    stringstream ss(s);
    int num;
    
    while(ss >> num)
        v.push_back(num);
    
    sort(v.begin(), v.end());
    
    string ret = "";
    ret += to_string(v[0]);
    ret += " ";
    ret += to_string(v[v.size() - 1]);
    
    return ret;
    
    
}