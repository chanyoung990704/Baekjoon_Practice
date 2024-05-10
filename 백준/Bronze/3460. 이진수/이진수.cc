#include <algorithm>
#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int T;  cin >> T;

    for(int test_case = 0; test_case < T; test_case++) {
        int n;  cin >> n;
        if(n == 1){
            cout << 0 << "\n";
            continue;
        }
        vector<int> idx;

        while(n > 1) {

            idx.push_back(n % 2);
            if(n % 2 == 1)
                cout << idx.size() - 1 << " ";
            n /= 2;
        }

        idx.push_back(1);
        cout << idx.size() - 1 << "\n";

    }

}