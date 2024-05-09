#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {

    int N;  cin >> N;
    vector<int> T_v(N + 2), P_v(N + 2);
    for(int i = 1 ; i <= N ; i++)
        cin >> T_v[i] >> P_v[i];

    // DP 사용
    vector<int> dp(N + 2, 0);

    for(int i = 1 ; i <= N ; i++) {

        // 상담을 진행하는 경우
        if(i + T_v[i] <= N + 1) {
            dp[i + T_v[i]] = max(dp[i + T_v[i]], dp[i] + P_v[i]);
        }

        // 상담을 진행하지 않는 경우
        dp[i + 1] = max(dp[i + 1], dp[i]);
    }


    cout << dp[N + 1] << "\n";
}