#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;	cin >> N;

	int result = 0;
	for (int i = 0; i < N; i++) {

		string word;	cin >> word;
		
		bool isGroup = true;
		vector<bool> visited(26, false);
		char prev = word[0];
		visited[prev - 'a'] = true;

		for (int j = 1; j < word.size(); j++) {
			if (prev != word[j]) { // 이전과 같지 않은 경우
				if (visited[word[j] - 'a']) { // 이미 방문했으면
					isGroup = false;
					break;
				}
				else { // 방문 안했으면
					visited[word[j] - 'a'] = true;
				}
			}

			prev = word[j];

		}

		if (isGroup)
			result++;

	}


	cout << result << "\n";

}