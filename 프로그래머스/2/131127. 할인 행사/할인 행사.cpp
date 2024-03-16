#include <string>
#include <vector>
#include <map>

using namespace std;

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    
    map<string, int> wantNumber;
    for(int i = 0 ; i < want.size() ; i++)
        wantNumber[want[i]] = number[i];
    
    int ret = 0;
    // 완전탐색??
    for(int i = 0 ; i <= discount.size() - 10 ; i++) {
        
        map<string,int> tmp;
        for(int j = i ; j < i + 10; j++) {
            tmp[discount[j]]++;
        }
        
        bool isPossible = true;
        for(int j = 0 ; j < want.size() ; j++) {
            if(wantNumber[want[j]] != tmp[want[j]])
                isPossible = false;
        }
        
        if(isPossible)
            ret++;
    }
    
    return ret;
}