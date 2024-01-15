#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<string> croatiaAlphabet = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

	string word;	cin >> word;
	int cnt = 0;

	for (string croAlpha : croatiaAlphabet) {
		size_t pos = word.find(croAlpha);
		while (pos != string::npos)
		{
			cnt++;
			word.replace(pos, croAlpha.size(), " ");
			pos = word.find(croAlpha, pos + 1); // 찾은 단어 다음부터 찾기
		}

	}

	for (char tmp : word)
		if (tmp != ' ')
			cnt++;

	cout << cnt << "\n";

}
