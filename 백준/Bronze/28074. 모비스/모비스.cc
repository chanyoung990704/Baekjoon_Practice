#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <stack>
#include <set>
#include <string>
#include <cstring>
using namespace std;




int main() {


	set<char> alphabets;
	string input;	 cin >> input;

	for (int i = 0; i < input.size(); i++)
	{

		alphabets.insert(input[i]);

	}


	vector<char> mobis = { 'M', 'O', 'B', 'I', 'S' };

	bool isTrue = true;

	for (int i = 0; i < mobis.size(); i++)
	{
		if (alphabets.count(mobis[i]) != 1)
		{
			isTrue = false;
			break;
		}


	}

	
	if (isTrue)
		cout << "YES" << "\n";
	else
		cout << "NO" << "\n";


}

