#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct comparator {

	vector<int>& group;
	int t;

	comparator(vector<int>& _group, int _t): group(_group), t(_t) {}

	bool operator() (int a, int b) {
		if (group[a] != group[b])
			return group[a] < group[b];
		else
			return group[a + t] < group[b + t];
	}

};

vector<int> getSuffixArray(string& s) {

	int n = s.size();
	int t = 1;

	vector<int> group(n + 1);
	for (int i = 0; i < n; i++)
		group[i] = s[i];
	group[n] = -1;

	vector<int> perm(n);
	for (int i = 0; i < n; i++)
		perm[i] = i;

	while (t < n)
	{
		comparator cmp(group, t);
		sort(perm.begin(), perm.end(), cmp);

		t *= 2;
		if (t >= n)
			break;

		vector<int> newGroup(n + 1);
		newGroup[n] = -1;
		newGroup[perm[0]] = 0;

		for (int i = 1; i < n; i++)
			if (cmp(perm[i -1], perm[i]))
				newGroup[perm[i]] = newGroup[perm[i - 1]] + 1;
			else
				newGroup[perm[i]] = newGroup[perm[i - 1]];

		group = newGroup;
	}

	return perm;
}


vector<int> getLCPArray(string& s, vector<int>& suffixArray) {
	int n = s.size();
	vector<int> ret(n, 0);
	vector<int> pos(n + 1, 0);

	for (int i = 0; i < n; i++)
		pos[suffixArray[i]] = i;

	for (int i = 0, k = 0; i < n; i++, k = max(k - 1, 0)) {
		if (pos[i] == n - 1)
			continue;

		int j = suffixArray[pos[i] + 1];
		while (s[i + k] == s[j + k])
		{
			k++;
		}
		ret[pos[i]] = k;
	}

	return ret;

}


int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string s;	cin >> s;
	
	vector<int> suffixArray = getSuffixArray(s);
	vector<int> lcpArray = getLCPArray(s, suffixArray);

	for (int i : suffixArray)
		cout << i + 1 << " ";
	cout << "\n";
	cout << "x ";

	for (int i = 0; i < s.size() - 1; i++)
		cout << lcpArray[i] << " ";

}