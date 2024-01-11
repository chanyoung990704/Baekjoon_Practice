#include <algorithm>
#include <iostream>
#include <map>
#include <vector>
#include <set>
#include <stack>

using namespace std;

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int M, N;	cin >> M >> N;

	map<int, string> numAlphabet;
	numAlphabet.insert({ 0, "zero" });
	numAlphabet.insert({ 1, "one" });
	numAlphabet.insert({ 2, "two" });
	numAlphabet.insert({ 3, "three" });
	numAlphabet.insert({ 4, "four" });
	numAlphabet.insert({ 5, "five" });
	numAlphabet.insert({ 6, "six" });
	numAlphabet.insert({ 7, "seven" });
	numAlphabet.insert({ 8, "eight" });
	numAlphabet.insert({ 9, "nine" });


	set<pair<string, int>> result;

	for (int i = M; i <= N; i++) {
		stack<int> stackTmp;
		string tmp;
		int numTmp = i;

		while (numTmp > 0) {

			if (numTmp % 10 == 0)
				stackTmp.push(0);
			else
				stackTmp.push(numTmp % 10);
			numTmp /= 10;
		}

		while (!stackTmp.empty())
		{
			string stackAlphabet = numAlphabet[stackTmp.top()];
			stackTmp.pop();

			tmp += stackAlphabet + " ";
		}

		result.insert({ tmp, i });

	}

	int resultCnt = 0;

	for (pair<string, int> r : result) {
		cout << r.second << " ";
		resultCnt++;
		if (resultCnt % 10 == 0)
			cout << "\n";
	}

	
}