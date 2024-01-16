#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
using namespace std;
typedef long long ll;
const int MAX_N = 51;
const ll infl = 0x3c3c3c3c3c3c3c3c;


int N;
ll K;
ll dp[MAX_N][MAX_N * 2][2];

ll findDp(int pos, int open, int wrong)
{
	if (pos == N)
		return wrong || open != 0;

	ll& ret = dp[pos][open + N][wrong];
	if (ret != infl)
		return ret;

	ret = 0;
	ret += findDp(pos + 1, open + 1, wrong);
	ret += findDp(pos + 1, open - 1, wrong || open <= 0);

	return ret;

}



void trackingParen(int pos, int open, int wrong, ll k)
{
	if (pos == N)
		return;

	if (dp[pos + 1][open + N + 1][wrong] >= k)
	{
		if (pos == N - 1 && k == 2)
			cout << ")";
		else
			cout << "(";

		trackingParen(pos + 1, open + 1, wrong, k);
	}

	else
	{
		cout << ")";
		trackingParen(pos + 1, open - 1, wrong || open <= 0, k - dp[pos + 1][open + 1 + N][wrong]);
	}


}



int main()
{
	memset(dp, 0x3c, sizeof(dp));
	cin >> N >> K;
	findDp(0, 0, 0);
	if (K + 1 > dp[0][N][0])
	{
		cout << -1;
		return 0;
	}

	trackingParen(0, 0, 0, K + 1);
	return 0;
}