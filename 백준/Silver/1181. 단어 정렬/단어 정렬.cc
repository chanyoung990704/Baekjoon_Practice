#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

bool compare(string a, string b) {

	if (a.length() == b.length())
	{
		for (int i = 0; i < a.length(); i++)
		{
			if (a[i] != b[i])
				return a[i] < b[i];
		}
	}

	return a.length() < b.length();
}




int main() {

	int N;
	cin >> N;

	vector<string> arr;
	
	for (int i = 0; i < N; i++)
	{
		string str;
		cin >> str;
		arr.push_back(str);
	}


	sort(arr.begin(), arr.end(), compare);

	for (int i = 0; i < N-1; i++)
	{
		if (arr[i] == arr[i + 1])
			continue;
		cout << arr[i] << endl;
	}

	cout << arr[N - 1] << endl;
}