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

vector<pair<int, int>> schedule;
int N;
int result = 0;

void bruteForce(int day, int val)
{
	if (day > N)
		return;

	result = max(result, val);

	for (int i = day; i < N; i++)
	{

		bruteForce(i + schedule[i].first, val + schedule[i].second);

	}


}



int main() {


	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;

	for (int i = 0; i < N; i++)
	{
		int t, p;	cin >> t >> p;
		schedule.push_back(make_pair(t, p));

	}


	bruteForce(0, 0);

	cout << result << "\n";



}

