#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

int main() {
    int N, A_p, B_p;
    cin >> N >> A_p >> B_p;

    vector<int> dp(N + 1, INT_MAX);
    dp[0] = 0;

    for (int i = 1; i <= N; ++i) {
        if (i >= A_p && dp[i - A_p] != INT_MAX) {
            dp[i] = min(dp[i], dp[i - A_p] + 1);
        }
        if (i >= B_p && dp[i - B_p] != INT_MAX) {
            dp[i] = min(dp[i], dp[i - B_p] + 1);
        }
    }

    if (dp[N] == INT_MAX) {
        cout << -1 << endl;
    } else {
        cout << dp[N] << endl;
    }

    return 0;
}

