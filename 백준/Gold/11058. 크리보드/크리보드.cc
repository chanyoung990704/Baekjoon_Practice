#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;  cin >> N;

    vector<long long> dp(100 + 1);
    dp[1] = 1; dp[2] = 2; dp[3] = 3; dp[4] = 4; dp[5] = 5; dp[6] = 6;

    if(N < 7){

        cout << dp[N] << "\n";
        return 0;
    }

    for (int i = 7; i <= N; i++) {
        // A추가
        dp[i] = dp[i - 1] + 1;

        // 복사
        for(int j = 1 ; j <= i - 3 ; j++){
            dp[i] = max(dp[i], dp[j] * (i - j - 1));
        }
    }

    cout << dp[N] << '\n';
    
    return 0;
            
}