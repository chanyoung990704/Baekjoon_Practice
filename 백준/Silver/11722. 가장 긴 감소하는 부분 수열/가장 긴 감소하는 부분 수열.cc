#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;  cin >> N;
    vector<int> num_v(N);
    for(int i = 0 ; i <  N ; i++)
        cin >> num_v[i];
    
    // DP 적용
    vector<int> dp(N, 1);
    for(int i = 1 ; i < N ; i++){
        for(int j = 0 ; j < i ; j++){
            if(num_v[j] > num_v[i])
                dp[i] = max(dp[i], dp[j]+  1);
        }
    }


    int res = 0;
    for(auto i : dp)
        res = max(res, i);

    cout << res << "\n";
}