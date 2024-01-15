#include <algorithm>
#include <cstring>
#include <string>
#include <vector>
#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	while (true)
	{
		int n;	cin >> n;

		if (n == 0)
			break;

		vector<pair<string,string>> words(n); // <원본, 소문자>
		string lowerResult(20, 'z');
		string result;
		
		for (int i = 0; i < n; i++) {
			cin >> words[i].first;
			words[i].second = words[i].first;
		}

		// 소문자 변환
		for (int i = 0; i < words.size(); i++) { 
			for (int j = 0; j < words[i].first.size(); j++) {
				if (words[i].first[j] >= 'A' && words[i].first[j] <= 'Z') {
					words[i].second[j] = tolower(words[i].first[j]);
				}
			}

			if (words[i].second < lowerResult) {
				lowerResult = words[i].second;
				result = words[i].first;
			}
		}

		cout << result << "\n";

	}

}