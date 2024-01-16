#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, S, R;
    cin >> N >> S >> R;
    vector<int> team(N + 1, 1);

    for (int i = 0; i < S; i++) {
        int broken; cin >> broken;
        team[broken]--;
    }

    for (int i = 0; i < R; i++) {
        int extra; cin >> extra;
        team[extra]++;
    }

    int cnt = 0;
    for (int i = 1; i <= N; i++) {
        if (team[i] == 0) { // 카약이 손상된 팀
            if (i > 1 && team[i - 1] > 1) { // 바로 전 팀에게서 카약을 빌림
                team[i - 1]--;
                team[i]++;
            } else if (i < N && team[i + 1] > 1) { // 바로 다음 팀에게서 카약을 빌림
                team[i + 1]--;
                team[i]++;
            } else {
                cnt++; // 카약을 빌릴 수 없음
            }
        }
    }

    cout << cnt << "\n";
    return 0;
}
