#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int dq_find(deque<int>& dq, int num) {
	deque<int>::iterator iter;
	int idx = 0;
	for (iter = dq.begin(); iter < dq.end(); iter++) {
		if (*iter == num)
			return idx;
		idx++;
	}

	return -1;
}


int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;	cin >> N;
	int M;	cin >> M;

	vector<int> nums(M);
	for (int i = 0; i < M; i++)
		cin >> nums[i];

	deque<int> dq;
	for (int i = 1; i <= N; i++)
		dq.push_back(i);

	int result = 0;
	for (int num : nums) {

		int find_idx = dq_find(dq, num); // 왼쪽으로 이동하는 연산량과도 같음.
		
		// 1번 작업을 바로 수행하는 경우
		if (find_idx == 0) {
			dq.pop_front();
			continue;
		}

		int right_move = dq.size() - find_idx;

		// 왼쪽 이동을 하는 경우
		if (find_idx < right_move) {
			result += find_idx;
			for (int i = 0; i < find_idx; i++) {
				dq.push_back(dq.front());
				dq.pop_front();
			}
		}

		// 오른쪽 이동을 하는 경우
		else {
			result += right_move;
			for (int i = 0; i < right_move; i++) {
				dq.push_front(dq.back());
				dq.pop_back();
			}
		}

		// 원소 뽑기
		dq.pop_front();

	}

	cout << result << "\n";
}