#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int dp_sol(int y, int x, int n, vector<int>& dp) {
    // base case
    if (y == x)
        return 0;
    if (y < x)
        return 1e9;

    // dp
    int& ret = dp[y];
    if (ret != -1)
        return ret;

    ret = 1e9;
    // n 빼기
    if (y - n >= x)
        ret = min(ret, dp_sol(y - n, x, n, dp) + 1);

    // 2 나누기
    if (y % 2 == 0 && y / 2 >= x)
        ret = min(ret, dp_sol(y / 2, x, n, dp) + 1);

    // 3 나누기
    if (y % 3 == 0 && y / 3 >= x)
        ret = min(ret, dp_sol(y / 3, x, n, dp) + 1);

    return ret;
}

int solution(int x, int y, int n) {
    vector<int> dp(y + 1, -1);
    int answer = dp_sol(y, x, n, dp);

    if (answer == 1e9)
        answer = -1;

    return answer;
}