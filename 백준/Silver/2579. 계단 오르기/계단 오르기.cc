#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {

    int N;  cin >> N;
    vector<int> scores(N+1);
    vector<int> dp(N + 1, -1);

    for(int i = 1 ; i <= N ; i++)
        cin >> scores[i];

    dp[0] = 0;
    dp[1] = scores[1];
    dp[2] = scores[1] + scores[2];

    for(int i = 3 ; i <= N ; i++)
        dp[i] = max(scores[i] + dp[i - 2], scores[i] + dp[i-3] + scores[i - 1]);


    cout << dp[N] << "\n"; 

    
}