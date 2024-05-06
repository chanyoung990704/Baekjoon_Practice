#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

long long get_total_person(vector<long long>& test_times, long long mid, long long M) {
    long long res = 0;
    for(auto time : test_times)
        if(time <= mid){
            res += mid / time;
            if(res >= M)
                break;
        }

    return res;
}

int main() {

    int N;  cin >> N;
    long long M;    cin >> M;

    vector<long long> test_times(N);
    for(int i = 0 ; i < N ; i++)
        cin >> test_times[i];
    
    long long max_time = *max_element(test_times.begin(), test_times.end());
    // 이진탐색 수행
    long long lo = 1, hi = max_time * M;
    long long res = 0;
    while(lo <= hi) {

        long long mid = (lo + hi) / 2;

        long long totals = get_total_person(test_times, mid, M);

        if(totals >= M) {
            res = mid;
            hi = mid - 1;

        }else{
            lo = mid + 1;
        }

    }

    cout << res << "\n";
}