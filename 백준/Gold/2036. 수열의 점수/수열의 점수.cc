#include <algorithm>
#include <iostream>
#include <queue>

using namespace std;

int main() {
	
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;	cin >> n;
	priority_queue<long long, vector<long long>, greater<long long>> mpq; // -를 담는 pq
	priority_queue<long long> pq;

	for (int i = 0; i < n; i++) {
		long long num;	cin >> num;
		if (num <= 0)
			mpq.push(num);
		else
			pq.push(num);
	}
	
	long long result = 0;

	// 음수 처리
	while (!mpq.empty()) {
		if (mpq.size() == 1) { // 홀수 개일 때 
			result += mpq.top();
			mpq.pop();
		}
		else {
			long long num1 = mpq.top();
			mpq.pop();
			long long num2 = mpq.top();
			mpq.pop();

			result += num1 * num2;
		}
	}
	// 양수 처리
	while (!pq.empty())
	{
		if (pq.size() == 1) { // 홀수 개일 때
			result += pq.top();
			pq.pop();
		}
		else {
			long long num1 = pq.top();
			pq.pop();
			long long num2 = pq.top();
			pq.pop();

			if (num1 <= 1 || num2 <= 1)
				result += (num1 + num2);
			else
				result += (num1 * num2);
		}
	}

	cout << result << "\n";
}