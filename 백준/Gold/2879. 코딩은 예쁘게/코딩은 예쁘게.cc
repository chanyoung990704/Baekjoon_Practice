#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

const int MAX = 1000;
int N, before[MAX], diff[MAX];

void calculate_diff() {
    for (int i = 0; i < N; i++) {
        int tab;
        cin >> tab;
        diff[i] = before[i] - tab;
    }
}

int main(void) {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++) cin >> before[i];
    calculate_diff();

    if (N == 1) {
        cout << abs(diff[0]) << "\n";
    }
    else {
        int result = 0;
        int prev = diff[0];
        int cur = diff[0];

        for (int i = 1; i < N; i++) {
            if (diff[i] >= 0) {
                if (prev < 0) {
                    result += abs(prev);
                    prev = diff[i];
                }
                else if (prev < diff[i]) {
                    prev = diff[i];
                }
                else {
                    result += abs(prev) - abs(diff[i]);
                    prev = cur = diff[i];
                }
            }
            else {
                if (prev > 0) {
                    result += prev;
                    prev = diff[i];
                }
                else if (prev > diff[i]) {
                    prev = diff[i];
                }
                else {
                    result += abs(prev) - abs(diff[i]);
                    prev = cur = diff[i];
                }
            }
        }
        result += abs(prev);
        cout << result << "\n";
    }
    return 0;
}
