#include <iostream>
#include <vector>
using namespace std;

int main() {
    int N, S;
    cin >> N >> S;
    vector<int> nums(N);
    for (int i = 0; i < N; i++) {
        cin >> nums[i];
    }

    int left = 0, right = 0, sum = 0, minLen = N + 1;
    while (true) {
        if (sum >= S) {
            minLen = min(minLen, right - left);
            sum -= nums[left++];
        } else if (right == N) {
            break;
        } else {
            sum += nums[right++];
        }
    }

    if (minLen == N + 1) {
        cout << 0 << endl;
    } else {
        cout << minLen << endl;
    }
    return 0;
}