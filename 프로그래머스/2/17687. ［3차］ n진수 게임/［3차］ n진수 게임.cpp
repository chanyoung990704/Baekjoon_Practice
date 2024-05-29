#include <string>
#include <vector>

using namespace std;

string solution(int n, int t, int m, int p) {
    string answer = "";
    
    vector<string> v = {"A", "B", "C", "D", "E", "F"};
    
    string total = "0";
    
    for(int i = 1 ; i <= t * m ; i++) {
        string tmp;
        int num = i;
        
        while(num > 0) {
            
            if(num % n >= 10){
                tmp = v[(num % n) % 10] + tmp;
            }else{
                tmp = to_string(num % n) + tmp;
            }
            
            num /= n;
        }
        
        total = total + tmp;
    }
    
    
    for(int i = p - 1 ; i < total.size() ; i += m) {
        answer.push_back(total[i]);
        if(answer.size() == t)
            break;
    }
    
    
    return answer;
}