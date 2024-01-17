#include <algorithm>
#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;
    vector<int> predictedRanks(N);

    for (int i = 0; i < N; i++) {
        cin >> predictedRanks[i];
    }

    // 예상 등수를 정렬합니다.
    sort(predictedRanks.begin(), predictedRanks.end());

    long long result = 0;

    // 정렬된 예상 등수에 대하여 실제 등수를 할당하면서 불만도를 계산합니다.
    for (int i = 0; i < N; i++) {
        // 불만도는 예상 등수와 i+1(실제 등수)의 차이의 절대값입니다.
        result += abs(predictedRanks[i] - (i + 1));
    }

    cout << result << "\n";

    return 0;
}
