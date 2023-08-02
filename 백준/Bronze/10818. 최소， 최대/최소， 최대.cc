#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <set>

using namespace std;



int main() {


	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	//최솟값, 최댓값 구하는 문제
	//우선순위 큐를 활용.

	priority_queue<int> maxQ;
	priority_queue<int, vector<int>, greater<>>  minQ;


	int N;	cin >> N;

	for (int i = 0; i < N; i++)
	{
		int num;	cin >> num;
		maxQ.push(num);
		minQ.push(num);
	}



	cout << minQ.top() << " " << maxQ.top() << "\n";





}

