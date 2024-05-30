#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    

    long long S;    cin >> S;

    long long lo = 1;
    long long hi = 4294967295;
    long long ret = 0;
    while(lo <= hi){
        long long mid = (lo + hi) / 2;

        long long total_sum = mid * (mid + 1) / 2;

        if(total_sum > S){
            //개수 줄여야 함
            hi = mid - 1;
        }else{
            // 개수 늘려야 함
            ret = mid;
            lo = mid + 1;
        }

    }

    cout << ret << "\n";

}