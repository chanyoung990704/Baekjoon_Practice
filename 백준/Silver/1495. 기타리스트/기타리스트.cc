#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, S, M;
    cin >> N >> S >> M;

    vector<int> V(N);
    for(int i = 0 ; i < N ; i++)
        cin >> V[i];

    // 2차원 DP
    vector<vector<bool>> dp(N + 1, vector<bool>(M + 1, false));
    dp[0][S] = true;
    
    for(int i = 0 ; i < N ; i++)
        for(int j = 0; j <= M ; j++)
            if(dp[i][j]) {
                // 볼륨을 줄인다
                if(j - V[i] >= 0) {
                    dp[i + 1][j - V[i]] = true;
                }

                // 볼륨을 높인다
                if(j + V[i] <= M) {
                    dp[i + 1][j + V[i]] = true;
                }
            }

    
    int result = -1;
    for(int i = 0 ; i <= M ; i++)
        if(dp[N][i])
            result = max(result, i);


    cout << result << '\n';
            
}