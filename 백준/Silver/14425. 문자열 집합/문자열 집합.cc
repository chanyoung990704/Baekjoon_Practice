#include <algorithm>
#include <iostream>
#include <set>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;	cin >> N;
	int M;	cin >> M;
	int result = 0;

	set<string> words;
	for (int i = 0; i < N; i++)
	{
		string word;	cin >> word;
		words.insert(word);
	}

	for (int i = 0; i < M; i++)
	{
		string findWord;	cin >> findWord;
		if (words.count(findWord) != 0)
			result++;
	}

	cout << result << "\n";
}