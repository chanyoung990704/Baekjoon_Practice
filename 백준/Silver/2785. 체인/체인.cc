#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;  cin >> N;

    vector<long long> ring;

    for (int i = 0; i < N; i++) {
        int cnt;    cin >> cnt;
        ring.push_back(cnt);
    }

    sort(ring.begin(), ring.end());
    long long result = 0;
    int left = 0; // leftIdx
    int right = N - 1; // righIdx

    while (left< right)
    {
        ring[left]--;
        ring[right]++;

        if (ring[left] == 0)
            left++;

        right--;
        result++;
    }

    cout << result << "\n";
}
