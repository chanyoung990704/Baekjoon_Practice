#include <algorithm>
#include <iostream>
#include <stack>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int cnt = 1;

	while (true) {
		string s1;	cin >> s1;
		stack<char> stack;

		if (s1[0] == '-')
			break;

		int result = 0;

		for (int i = 0; i < s1.size(); i++) {
			if (stack.empty() && s1[i] == '}')
			{
				result++;
				stack.push('{');
			}
			else if (!stack.empty() && s1[i] == '}')
				stack.pop();
			else
				stack.push('{');
		}

		result += stack.size() / 2;

		cout << cnt++ << ". ";
		cout << result << "\n";
	}

}