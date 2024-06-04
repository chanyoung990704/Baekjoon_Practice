#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    
    vector<int> dp(60000 + 1);
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    
    if(n <= 2)
        return dp[n];
    
    for(int i = 3 ; i <= n ; i++)
        dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
    
    answer = dp[n];
    
    return answer;
}