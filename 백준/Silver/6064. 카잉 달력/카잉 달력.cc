#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <math.h>
#include <stack>
#include <set>
#include <string>
#include <cstring>
using namespace std;

int M, N, x, y;

int gcd(int a, int b)
{
	if (b == 0)
		return a;
	else
		return gcd(b, a % b);
}


int lcm(int a, int b)
{
	return a * b / gcd(a, b);
}


int main() {


	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T; cin >> T;

	for (int t = 0; t < T; t++)
	{
		bool isTrue = false;
		cin >> M >> N >> x >> y;

		x--;
		y--;

		for (int k = x; k <= lcm(M, N); k += M)
		{
			if (k % N == y)
			{
				isTrue = true;
				cout << k + 1 << "\n";
				break;
			}
		}

		if (!isTrue)
			cout << "-1" << "\n";

	}
}

