#include <algorithm>
#include <iostream>
#include <vector>
#include <tuple>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;  cin >> N;
    int L;  cin >> L;

    vector<pair<int, int>> distance(N);

    for (int i = 0; i < N; i++)
    {
        int from;    cin >> from;
        int to;      cin >> to;
        distance[i] = make_pair(from, to);
    }

    sort(distance.begin(), distance.end());

    int result = 0;
    int end = 0;

    for (pair<int, int> inf : distance) {
        if (inf.first > end) {
            end = inf.first;
        }
        while (end < inf.second) {
            end += L;
            result++;
        }
    }

    cout << result << "\n";
}
