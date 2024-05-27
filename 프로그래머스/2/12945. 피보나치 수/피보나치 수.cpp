#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    
    vector<int> fibo_dp(n + 1, 0);
    fibo_dp[1] = 1;
    int& answer = fibo_dp[n];
    
    for(int i = 2 ; i <= n ; i++){
        fibo_dp[i] = (fibo_dp[i - 1] + fibo_dp[i - 2]) % 1234567;
    }
    
    return answer;
}