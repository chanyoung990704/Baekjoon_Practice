#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, K, I;    cin >> N >> K >> I;

    int result = -1;
    int round = 1;

    while (N > 0) {
        bool isMatch = false;

        // 만나는지 확인
        for (int i = 1; i <= N; i += 2) {
            //만나면 종료
            if (i == min(K, I) && i + 1 == max(K, I)) {
                result = round;
                isMatch = true;
                break;
            }
        }

        if (isMatch)
            break;

        // 홀수일 때 N 갱신
        if (N % 2 == 1) {
            N = N / 2 + 1;
        }
        else {
            N = N / 2;
        }

        // 홀수일 때 K 갱신
        if (K % 2 == 1) {
            K = K / 2 + 1;
        }
        else {
            K = K / 2;
        }

        //홀수일 때 I 갱신
        if (I % 2 == 1) {
            I = I / 2 + 1;
        }
        else {
            I = I / 2;
        }

        // round 갱신
        round++;
    }

    cout << result << "\n";
}
