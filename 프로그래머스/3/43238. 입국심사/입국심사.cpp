#include <vector>

using namespace std;

long long solution(int n, vector<int> times) {

    long long lo = 0;
    long long hi = times.size() * 1000000000;
    
    // mid 값은 시간
    // n 보다 크면 시간을 줄이면 된다.(hi에서 값이 나올듯.)
    while(lo < hi) {
        
        long long mid = (lo + hi) / 2;
        long long cnt = 0;
        for(int time : times) {
            cnt += mid / time;
        }
        
        if(cnt>= n)
            hi = mid;
        else
            lo = mid + 1;
        
    }
    
    return hi;
}