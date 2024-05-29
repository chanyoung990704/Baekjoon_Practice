#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int T;  cin >> T;

    for(int tc = 0 ; tc < T ; tc++){
        int N;  cin >> N;
        vector<int> arr(N);

        for(int i = 0 ; i < N ; i++)
            cin >> arr[i];

        cout << *min_element(arr.begin(), arr.end()) << " ";
        cout << *max_element(arr.begin(), arr.end()) << "\n";
    }
}