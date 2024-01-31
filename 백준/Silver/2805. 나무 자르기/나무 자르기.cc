#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;	cin >> N; // 나무 개수
	long long M;	cin >> M; // 원하는 나무 길이

	vector<long long> trees(N);
	for (int i = 0; i < N; i++)
		cin >> trees[i];

	vector<long long>::iterator maxIter = max_element(trees.begin(), trees.end());
	long long lo = 0;
	long long hi = *maxIter;
	
	while (lo + 1 < hi)
	{
		long long mid = (lo + hi) / 2; // 중앙값
		
		long long sum = 0;
		for (int tree : trees)
			if (tree > mid)
				sum += tree - mid;

		if (sum < M) // 조건을 불만족하는 경우
			hi = mid;
		else // 조건을 만족하는 경우
			lo = mid;

	}
	
	cout << lo << "\n";
}