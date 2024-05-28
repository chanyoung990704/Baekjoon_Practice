#include <algorithm>
#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N;  cin >> N;

    string s;   cin >> s;
    int total = 0;

    for(auto& c : s){
        int n = c - '0';
        total += n;
    }

    cout << total << "\n";
}