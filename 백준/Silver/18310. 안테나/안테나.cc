#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N;
    cin >> N;
    vector<int> house(N);
    for(auto& h : house)
        cin >> h;

    sort(house.begin(), house.end());

    // 중앙값 선택
    cout << house[(N-1)/2] << "\n";

    return 0;
}