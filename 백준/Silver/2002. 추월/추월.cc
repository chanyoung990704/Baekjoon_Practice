#include <algorithm>
#include <iostream>
#include <map>
#include <vector>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;	cin >> N;

	map<string, int> startList;
	vector<string> endList(N);

	for (int i = 0; i < N; i++) {
		string name;	cin >> name;
		startList.insert({ name, i });
	}

	for (int i = 0; i < N; i++)
		cin >> endList[i];

	int result = 0;
	
	for(int i = 0 ; i <N ; i++) // 도착차들 순서대로 검사
		for (int j = i + 1; j < N; j++) // 차들 전체 비교
		{
			if (startList[endList[i]] > startList[endList[j]]) // 먼저 출발하지 않았다면
			{
				result++;
				break;
			}
		}

	cout << result << "\n";

}