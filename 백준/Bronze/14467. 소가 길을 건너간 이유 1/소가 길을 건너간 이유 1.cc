#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N;  cin >> N;

    vector<int> arr(11, -1);
    int cnt = 0;
    for(int i = 0 ; i < N ; i++) {

        int idx, dir;
        cin >> idx >> dir;

        // 처음 발견
        if(arr[idx] == -1){
            arr[idx] = dir;
            continue;
        }

        // 재발견
        if(arr[idx] != dir){
            cnt++;
            arr[idx] = dir;
        }

    }

    cout << cnt << "\n";
}