#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <set>

using namespace std;
int N, K;


int main() {


	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);


	long long result = 0;
	cin >> N >> K;

	priority_queue<pair<long long, long long>> pq;
	//정렬을 위해 무게부터 push

	for (int i = 0; i < N; i++) {
		long long weight, val;	cin >> weight >> val;
		pq.push(make_pair(val, weight));

	}



	multiset<long long> bag;

	for (int i = 0; i < K; i++) {
		long long weight;		cin >> weight;
		bag.insert(weight);

	}

	


	while (!pq.empty()) {

		long long jewelWeight = pq.top().second;


		multiset<long long>::iterator iter = bag.lower_bound(jewelWeight);

		//가방에 넣을 수 없을 경우
		if (iter == bag.end())
		{
		
		}//가방에 넣을 수 있을 경우
		else {

			result += pq.top().first;
			bag.erase(iter);

		}


		pq.pop();

	}


	



	cout << result << endl;


}

