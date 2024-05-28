#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    vector<string> v(5);
    for(int i = 0; i < 5; i++) {
        getline(cin, v[i]);
    }

    string result;
    for(int i = 0; i < 15; i++) {
        for(int j = 0; j < 5; j++) {
            if(i < v[j].size()) {
                result.push_back(v[j][i]);
            }
        }
    }

    cout << result << "\n";
    return 0;
}