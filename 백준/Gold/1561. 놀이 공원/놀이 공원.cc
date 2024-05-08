#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

long long get_people_cnt(vector<int>& times, long long mid){
    long long ret = times.size();
    for(int i = 0 ; i < times.size() ; i++){

        ret += mid / times[i];
    }
    return ret;
}

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);


    long long N;    cin >> N;
    int M;  cin >> M;

    vector<int> times(M);
    for(int i = 0 ; i < M ; i++)
        cin >> times[i];


    if(N <= M) {
        cout << N << "\n";
        return 0;
    }

    // 최적 운행시간을 이분탐색으로 구한다
    long long lo = 1, hi = 30 * N;
    long long optimize_time = 0;

    while(lo <= hi) {

        long long mid = (lo + hi) / 2;
        long long cnt = get_people_cnt(times, mid);

        if(cnt >= N) {
            optimize_time = mid;
            hi = mid - 1;
        }else{
            lo = mid + 1;
        }

    }

    // 마지막 전까지 탑승 기록 조회
    long long cnt = M;
    for(int i = 0 ; i < times.size() ; i++)
        cnt += (optimize_time - 1) / times[i];

    // 마지막 탑승 조회
    for(int i = 0 ; i < times.size() ; i++){
        if(optimize_time % times[i] == 0)
            cnt++;
        if(cnt == N){
            cout << i + 1 << "\n";
            break;
        }
    }


}