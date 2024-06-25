#include <string>
#include <vector>

using namespace std;

int solution(string A, string B) {
    
    int cnt = 0;
    
    while(cnt < A.size()) {
        // 확인
        if(A == B)
            return cnt;
        
        // 이동
        
        int a_size = A.size();
        string perfix = A.substr(0, a_size - 1);
        A = A[a_size - 1] + perfix;
        
        cnt++;
    }

    return -1;
}