#include <iostream>
#include <sstream>
#include <string>
#include <algorithm>
using namespace std;
int main() {
	
	string s;
	int cnt = 0;
	
	getline(cin, s);
	
	stringstream ss(s);
	string token;
	while(getline(ss, token, ' ')){
		if(!token.empty())
			cnt++;
	}
	
	cout << cnt << "\n";
	return 0;
	
	
}
