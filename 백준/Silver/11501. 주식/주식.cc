#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;  cin >> T;
    while (T--)
    {
        int N;  cin >> N;
        vector<int> stockPrice(N);

        for (int i = 0; i < N; i++)
            cin >> stockPrice[i];

        long long maxVal = 0; // 최대 이익 저장
        int maxPrice = stockPrice[N - 1]; // 주식의 최대 가격

        for (int i = N - 2; i >= 0; i--) {
            if (stockPrice[i] > maxPrice) // 주식 가격이 이전 최대 가격보다 크다면, 최대 가격 갱신
                maxPrice = stockPrice[i];
            else // 주식 가격이 이전 최대 가격보다 작다면, 주식을 사서 이익 얻기
                maxVal += maxPrice - stockPrice[i];
        }

        cout << maxVal << "\n";
    }

    return 0;
}
