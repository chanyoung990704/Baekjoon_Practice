#include <algorithm>
#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    

    string S;   cin >> S;
    string K;   cin >> K;

    string tmp;
    for(auto& c : S)
        if(isalpha(c))
            tmp.push_back(c);

    if(tmp.find(K) == string::npos)
        cout << "0" << "\n";
    else
        cout << "1" << "\n"; 

}