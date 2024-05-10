#include <algorithm>
#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;  cin >> n;
    vector<int> fibonaci_dp(n + 1, 0);
    fibonaci_dp[0] = 0;
    fibonaci_dp[1] = 1;

    for(int i = 2 ; i <= n ; i++) {
        fibonaci_dp[i] = fibonaci_dp[i - 1] + fibonaci_dp[i - 2];
    }

    cout << fibonaci_dp[n] << "\n";

}