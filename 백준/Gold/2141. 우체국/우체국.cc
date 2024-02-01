#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;	cin >> N;
	vector<pair<long long, long long>> country(N);
	long long total = 0;

	for (int i = 0; i < N; i++)
	{
		long long number;	cin >> number;
		long long people;	cin >> people;
		country[i] = make_pair(number, people);
		total += people;
	}

	sort(country.begin(), country.end());

	long long cur = 0;
	long long target = (total + 1) / 2;

	for (auto c : country) {
		long long number = c.first;	long long people = c.second;
		cur += people;

		if (cur >= target)
		{
			cout << number << "\n";
			break;
		}
	}

}