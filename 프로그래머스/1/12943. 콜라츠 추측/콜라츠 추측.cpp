#include <string>
#include <vector>

using namespace std;

int solution(int num) {
    int answer = 0;
    
    long long n = num;
    
    int cnt = 0;
    while(n != 1){
        if(n % 2 == 0){
            n /= 2;
        }else{
            n *= 3;
            n++;
        }
        
        cnt++;
    }

    if(cnt > 500)
        answer = -1;
    else
        answer = cnt;
    
    return answer;
}