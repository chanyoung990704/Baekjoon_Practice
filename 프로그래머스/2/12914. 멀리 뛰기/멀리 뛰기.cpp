#include <string>
#include <vector>

using namespace std;

long long solution(int n) {
    long long answer = 0;
    
    vector<long long> dp(n + 1, 0);
    dp[0] = 1;
    
    for(int i = 1 ; i <= n ; i++){
        if(i >= 1)
            dp[i] += dp[i - 1];
        if(i >= 2)
            dp[i] += dp[i - 2];
        
        dp[i] %= 1234567;
    }
    
    
    return dp[n];
}