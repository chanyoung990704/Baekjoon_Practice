#include <algorithm>
#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;
    long long max_energy = pow(N, 3);
    vector<char> block(N+1);
    vector<long long> dp(N+1, max_energy);
    for(int i = 1; i <= N; i++) {
        cin >> block[i];
    }
    dp[1] = 0; // 시작점의 에너지 소모는 0

    for(int i = 1; i <= N; i++) {
        for(int j = i+1; j <= N; j++) {
            if((block[i] == 'B' && block[j] == 'O') || (block[i] == 'O' && block[j] == 'J') || (block[i] == 'J' && block[j] == 'B')) {
                long long cost = pow(j - i, 2);
                dp[j] = min(dp[j], dp[i] + cost);
            }
        }
    }

    if(dp[N] == max_energy)
        cout << "-1\n"; // 도달할 수 없는 경우
    else 
        cout << dp[N] << "\n";

    return 0;
}