#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N;  cin >> N;

    priority_queue<int, vector<int>, greater<int>> pq;

    for(int i = 0 ; i < N ; i++)
        for(int j = 0 ; j < N ; j++) {
            // 입력
            int num;    cin >> num;

            // pq의 사이즈만큼 일단 삽입
            if(pq.size() < N) {
                pq.push(num);
                continue;
            }

            // 최솟값을 빼고 현재 값 삽입
            if(pq.top() < num){
            pq.pop();
            pq.push(num);
            }

        }


    cout << pq.top() << "\n";    
}