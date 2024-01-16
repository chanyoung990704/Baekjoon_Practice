#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int money;	cin >> money;

	vector<int> exchanges = { 500, 100, 50, 10, 5, 1 }; //거스름 돈 개수
	int exchange = 1000 - money; // 잔돈
	int cnt = 0;

	for (int ex : exchanges) {

		while (exchange >= ex)
		{
			exchange -= ex;
			cnt++;
		}

	}

	cout << cnt << "\n";

}
