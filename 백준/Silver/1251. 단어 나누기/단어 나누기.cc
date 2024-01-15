#include <algorithm>
#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string word;	cin >> word;
	string result(50, 'z');

	for (int i = 0; i < word.size() - 2; i++) {
		for (int j = i + 1; j < word.size() - 1; j++) {
			string subWord1 = word.substr(0, i + 1);
			string subWord2 = word.substr(i + 1, j - i);
			string subWord3 = word.substr(j + 1, word.size() - j);

			reverse(subWord1.begin(), subWord1.end());
			reverse(subWord2.begin(), subWord2.end());
			reverse(subWord3.begin(), subWord3.end());

			string newWord = subWord1 + subWord2 + subWord3;
			if (newWord < result)
				result = newWord;
		}
	}

	cout << result << "\n";
}