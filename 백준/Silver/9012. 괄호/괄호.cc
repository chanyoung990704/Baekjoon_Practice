#include <algorithm>
#include <iostream>
#include <stack>
#include <vector>

using namespace std;

bool isVPS(string data) {
	stack<char> s;

	for (int i = 0; i < data.size(); i++) {

		if (data[i] == '(')
			s.push('(');

		if (data[i] == ')') {
			if (s.empty())
				return false;
			s.pop();
		}
	}

	return s.empty();
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;	cin >> T;
	vector<string> arr(T);
	for (int i = 0; i < T; i++)
		cin >> arr[i];

	for (string data : arr)
	{
		if (isVPS(data))
			cout << "YES\n";
		else
			cout << "NO\n";
	}

}