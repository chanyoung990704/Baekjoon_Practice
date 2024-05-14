#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n;  cin >> n;
    int k;  cin >> k;

    vector<vector<int>> distance_matrix(n + 1, vector<int>(n + 1, 100));
    for(int i = 0 ; i < k ; i++) {
        int from, to;   cin >> from >> to;
        distance_matrix[from][to] = 1;
    }

    for(int i = 1; i <= n ; i++)
        distance_matrix[i][i] = 0;

    // 3중 반복문 플로이드 워셜
    for(int i = 1; i <= n ; i++)
        for(int j = 1 ; j <= n ; j++)
            for(int k = 1 ; k <= n ; k++)
                distance_matrix[j][k] = min(distance_matrix[j][k], distance_matrix[j][i] + distance_matrix[i][k]);

    // 결과 출력
    int cnt;    cin >> cnt;
    for(int i = 0 ; i < cnt ; i++) {
        int from, to;   cin >> from >> to;
        int from_to = distance_matrix[from][to];
        int to_from = distance_matrix[to][from];

        // 값이 100이 아니면서 작으면 먼저 일어난것
        if(from_to < to_from) {
            cout << -1 << "\n";
        } else if(from_to > to_from) {
            cout << 1 << "\n";
        }else {
            cout << 0 << "\n";
        }
    }

}