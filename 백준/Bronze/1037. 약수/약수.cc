#include <algorithm>
#include <iostream>
#include <math.h>
#include <vector>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;	cin >> N;
	vector<int> nums(N);

	for (int i = 0; i < N; i++)
		cin >> nums[i];

	sort(nums.begin(), nums.end());

	if (nums.size() == 1)
		cout << pow(nums[0], 2) << "\n";
	else
		cout << nums[0] * nums[N - 1] << "\n";
}