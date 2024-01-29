#include <algorithm>
#include <iostream>
#include <queue>

using namespace std;

int main() {
	
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;	cin >> N;
	priority_queue<int, vector<int>, greater<int>> pq;
	
	for (int i = 0; i < N; i++)
	{
		int num;	cin >> num;
		pq.push(num);
	}

	long long result = 0;

	while (!pq.empty()) {

		if (pq.size() == 1) {
			pq.pop();
		}
		else
		{
			int num1 = pq.top();
			pq.pop();
			int num2 = pq.top();
			pq.pop();
			result += num1 + num2;
			pq.push(num1 + num2);
		}

	}

	cout << result << "\n";
}