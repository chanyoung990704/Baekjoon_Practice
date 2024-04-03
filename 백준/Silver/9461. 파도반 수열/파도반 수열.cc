#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

long long dp(vector<long long>& arr, int N) {
    // base case
    if (N <= 5) {
        return arr[N];
    }

    // dp
    long long& ret = arr[N];
    if (ret != -1)
        return ret;

    ret = dp(arr, N - 1) + dp(arr, N - 5);
    return ret;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;  cin >> T;
    vector<long long> arr(101, -1); // 배열의 크기를 101로 설정하여 인덱스 1부터 100까지 사용 가능하도록 함
    arr[1] = 1; arr[2] = 1; arr[3] = 1; arr[4] = 2; arr[5] = 2; // 파도반 수열 초기화

    while (T--) {
        int N;  cin >> N;
        cout << dp(arr, N) << "\n";
    }
}
