#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <stack>
#include <set>

using namespace std;



int main() {


	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);


	int N; cin >> N;

	stack<int> numStack;


	for (int i = 0; i < N; i++)
	{
		string op;	cin >> op;


		if (op == "push")
		{
			int num;	cin >> num;
			numStack.push(num);
		}

		if (op == "pop")
		{
			if (numStack.empty())
				cout << -1 << "\n";
			else
			{
				cout << numStack.top() << "\n";
				numStack.pop();
			}
		}

		if (op == "size")
		{
			cout << numStack.size() << "\n";
		}


		if (op == "empty")
		{
			if (numStack.empty())
				cout << 1 << "\n";
			else
				cout << 0 << "\n";
		}

		if (op == "top")
		{

			if (numStack.empty())
				cout << -1 << "\n";
			else
				cout << numStack.top() << "\n";


		}




	}




}

