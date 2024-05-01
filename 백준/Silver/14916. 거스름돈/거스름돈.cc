#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int getRemains(int n, vector<int>& dp) {
    // basecase
    if(n == 0)
        return 0;
    
    // dp
    int& ret = dp[n];
    if(ret != -1)
        return ret;
    ret = 987654321;
    
    if(n >= 2)
        ret = min(ret, getRemains(n - 2, dp) + 1);
    if(n >= 5)
        ret = min(ret, getRemains(n - 5, dp) + 1);

    return ret;
}

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    
    vector<int> dp(n+1, -1);
    int res = getRemains(n, dp);

    if(res == 987654321)
        cout << -1 << "\n";
    else
        cout << res << "\n";

    return 0;

}