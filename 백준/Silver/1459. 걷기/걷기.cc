#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    long long X;  cin >> X;
    long long Y;  cin >> Y;
    int W;  cin >> W; // 걸어서 한 블록
    int S;  cin >> S; // 대각선 한 블록

    long long result = 0;

    if (S < 2 * W) { // 1,1을 간다고 했을 때 걸어서 2번보다 대각선 1번이 더 나은 경우
        result += min(X, Y) * S; // 대각선으로 최대한
        long long distance = abs(X - Y);
        if (S < W) // 2칸을 이동할 때 대각 2번이 더 나은 경우
        {
            if (distance % 2 == 1) { // 남은 거리가 홀수라면
                result += (distance - 1) * S + W;
            }
            else { // 남은 거리가 짝수라면
                result += distance * S;
            }
        }
        else { // 그냥 걷는게 더 나은 경우
            result += distance * W;
        }
       
    }
    else { // 걸어서 2번이 나은 경우
        result += (X + Y) * W;
    }

    cout << result << "\n";

}
