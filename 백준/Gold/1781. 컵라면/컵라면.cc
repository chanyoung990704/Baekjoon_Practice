#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;  cin >> N;

    vector<pair<int, int>> problems(N);

    for (int i = 0; i < N; i++) {
        cin >> problems[i].first >> problems[i].second;
    }

    sort(problems.begin(), problems.end());

    priority_queue<int, vector<int>, greater<int>> pq;
    for (int i = 0; i < N; i++) {
        pq.push(problems[i].second);
        if (pq.size() > problems[i].first) {
            pq.pop();
        }
    }

    int result = 0;
    while (!pq.empty()) {
        result += pq.top();
        pq.pop();
    }

    cout << result << '\n';

    return 0;
}
