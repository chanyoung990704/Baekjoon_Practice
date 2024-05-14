#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;  cin >> n; // 노드
    int m;  cin >> m; // 간선

    // 플로이드 워셜
    vector<vector<long long>> distance_matrix(n + 1, vector<long long>(n + 1, 100000000));
    for(int i = 0; i < m; i++) {
        int from, to, dist;
        cin >> from >> to >> dist;
        // 중복 간선 처리를 위해 최소값만 저장
        if (distance_matrix[from][to] > dist) {
            distance_matrix[from][to] = dist;
        }
    }

    // 대각 원소는 0으로 초기화
    for(int i = 1 ; i <= n ; i++)
        distance_matrix[i][i] = 0;

    // 3중 반복문 구현
    for(int i = 1 ; i <= n ; i++) {

        int mid_node = i; // 중간 거쳐갈 노드

        for(int j = 1 ; j <= n ; j++) {
            for(int k = 1 ; k <= n ; k++) {
                // 중간 노드가 포함되면 안됨

                    int start = j;
                    int finish = k;
                    long long origin_distance = distance_matrix[start][finish];
                    long long new_distance = distance_matrix[start][mid_node] + distance_matrix[mid_node][finish];

                    distance_matrix[start][finish] = min(origin_distance, new_distance);
                
            }
        }


    }

    for(int i = 1 ; i <= n ; i++){
        for(int j = 1; j <= n ; j++)
            if(distance_matrix[i][j] == 100000000)
                cout << 0 << " ";
            else
                cout << distance_matrix[i][j] << " ";
        cout << "\n";
    }


}