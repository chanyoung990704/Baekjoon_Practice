#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;
    while (T--) {

        priority_queue<int, vector<int>, less<int>> pq;
        for(int i = 0 ; i < 10 ; i++){
            int n;
            cin >> n;
            pq.push(n);
        }

        int N = 3;

        while(N > 1 && !pq.empty()){
            pq.pop();
            N--;
        }

        cout << pq.top() << "\n";

    }
    
}