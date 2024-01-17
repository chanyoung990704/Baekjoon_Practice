#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;	cin >> n;
	
	vector<int> stat(2 * n);

	for (int i = 0; i < 2 * n; i++)
		cin >> stat[i];

	sort(stat.begin(), stat.end());

	int first = 0;
	int last = stat.size() - 1;
	int result = 987654321;

	while (first < last)
	{
		result = min(result, stat[first++] + stat[last--]);
	}

	cout << result << "\n";

}