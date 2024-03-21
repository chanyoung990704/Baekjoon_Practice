#include <string>
#include <vector>
#include <map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {

    map<string, int> m;
    
    for(string p : participant)
        m[p]++;
    for(string p : completion)
        m[p]--;
    
    string ret = "";
    for(string p : participant)
        if(m[p] > 0)
            ret = p;
    
    return ret;
}
