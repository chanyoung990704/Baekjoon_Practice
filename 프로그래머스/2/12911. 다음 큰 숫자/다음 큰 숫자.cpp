#include <string>
#include <vector>
#include <bitset>

using namespace std;

int solution(int n) {
    int answer = 0;
    
    int cnt = -1;
    
    for(int i = n ; i <= 1000000 ; i++){
        string binary_n = bitset<32>(i).to_string();
        
        size_t pos = binary_n.find("1");
        int tmp_cnt = 0;
        
        while(pos != string::npos){
            tmp_cnt++;
            pos = binary_n.find("1", pos + 1);
        }
        
        if(i == n){
            cnt = tmp_cnt;
            continue;
        }
        
        if(cnt == tmp_cnt){
            answer = i;
            break;
        }
        
    }
    
    
    return answer;
}