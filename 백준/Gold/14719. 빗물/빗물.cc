#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int H, W;  cin >> H >> W;
    vector<int> w_v(W);
    for(int i = 0 ; i < W ; i++)
      cin >> w_v[i];

    int sum = 0;

    for(int i = 1 ; i < W - 1 ; i++) {

        int left_max = *max_element(w_v.begin(), w_v.begin() + i);
        int right_max = *max_element(w_v.begin() + i + 1, w_v.end());

        int left_right_min = min(left_max, right_max);

        if(left_right_min > w_v[i])
            sum += left_right_min - w_v[i];

    }


    cout << sum << '\n';
    
}