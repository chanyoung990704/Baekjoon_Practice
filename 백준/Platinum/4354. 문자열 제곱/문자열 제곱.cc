#include <algorithm>
#include <iostream>
#include <vector>
#include <string>

using namespace std;

vector<int> failureTable(const string& pattern) {
	int size = pattern.size();
	vector<int> table(size);
	table[0] = 0;
	int j = 0;

	for (int i = 1; i < size; i++) {

		while (j > 0 && pattern[i] != pattern[j])
		{
			j = table[j - 1];
		}

		if (pattern[i] == pattern[j])
			++j;

		table[i] = j;
	}

	return table;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	while (true)
	{
		string T;	getline(cin, T);
		if (T == ".")
			break;

		vector<int> table = failureTable(T);
		int repeatSize = T.size() - table[T.size() - 1];

		if (T.size() % repeatSize == 0)
			cout << T.size() / repeatSize << "\n";
		else
			cout << 1 << "\n";
	}

}