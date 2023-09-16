#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;

int N;

int dp[16][1 << 16];
int W[17][17];

int getMinWeight(int cur, int visit)
{
	int& ret = dp[cur][visit];
	if (ret != -1)
		return ret;

	if (visit == ((1 << N) - 1))
	{
		if (W[cur][0] != 0)
			return W[cur][0];
		else
			return 987654321;
	}


	ret = 987654321;

	for (int i = 0; i < N; i++)
	{
		if (W[cur][i] == 0 || (visit & (1 << i)))
			continue;

		ret = min(ret, W[cur][i] + getMinWeight(i, visit | 1 << i));

	}


	return ret;


}





int main()
{

	cin >> N;
	for(int i = 0 ; i < N ; i++)
		for (int j = 0; j < N; j++)
		{
			cin >> W[i][j];
		}


	memset(dp, -1, sizeof(dp));
	

	cout << getMinWeight(0, 1) << "\n";




}