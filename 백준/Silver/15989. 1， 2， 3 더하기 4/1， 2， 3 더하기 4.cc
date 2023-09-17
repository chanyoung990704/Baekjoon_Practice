#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

#define MAX 10000 + 1

int dp[MAX][4];




int main()
{

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;	cin >> T;
	for (int test = 0; test < T; test++)
	{

		int N;
		cin >> N;


		for (int i = 0; i < MAX; i++)
			dp[i][1] = 1;

		for (int i = 1; i < MAX; i++)
		{
			if (i > 1)
				dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
			if (i > 2)
				dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
		}



		cout << dp[N][1] + dp[N][2] + dp[N][3] << "\n";

	}


}