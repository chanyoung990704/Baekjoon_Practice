#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    priority_queue<int, vector<int>, greater<int>> minValues;

    for (int i = 0; i < n; i++) {
        int p, l;
        cin >> p >> l;

        vector<int> v(p);
        for (int j = 0; j < p; j++) {
            cin >> v[j];
        }

        if (p < l) {
            minValues.push(1);
        } else {
            sort(v.begin(), v.end(), greater<int>());
            minValues.push(v[l-1]);
        }
    }

    int cnt = 0;
    while (!minValues.empty()) {
        int minValue = minValues.top();
        minValues.pop();

        if (m >= minValue) {
            m -= minValue;
            cnt++;
        } else {
            break;
        }
    }

    cout << cnt << "\n";

    return 0;
}
