#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int T;
    cin >> T;
    while (T--) {
        int N;
        cin >> N;
        string start, target;
        cin >> start >> target;
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < N; i++) {
            if (start[i] != target[i]) {
                if (target[i] == 'B') cnt1++;
                else cnt2++;
            }
        }
        cout << max(cnt1, cnt2) << "\n";
    }
    return 0;
}
