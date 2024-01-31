#include <algorithm>
#include <iostream>	
#include <vector>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;	cin >> N;
	vector<int> nVector(N);
	for (int i = 0; i < N; i++)
		cin >> nVector[i];

	int M;	cin >> M;
	vector<int> mVector(M);
	for (int i = 0; i < M; i++)
		cin >> mVector[i];

	sort(nVector.begin(), nVector.end());


	for (int target : mVector) {
		int lo = 0;
		int hi = N;

		while (lo + 1 < hi)
		{
			int mid = (lo + hi) / 2;
			if (nVector[mid] > target)
				hi = mid;
			else
				lo = mid;
		}

		if (nVector[lo] == target)
			cout << "1\n";
		else
			cout << "0\n";
	}

}