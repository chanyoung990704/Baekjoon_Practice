#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string s, t;

	while (cin >> s >> t)
	{
		size_t pos = 0;
		bool isTrue = true;

		for (char ss : s) {

			pos = t.find(ss, pos);
			if (pos == string::npos)
			{
				isTrue = false;
				break;
			}
			pos++;
		}

		if (isTrue)
			cout << "Yes" << "\n";
		else
			cout << "No" << "\n";

	}

}