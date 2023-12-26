#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>

using namespace std;

priority_queue<int> max_pq; // 최대 힙
priority_queue<int, vector<int>, greater<int>> min_pq; // 최소 힙

void calMedian(int val) {
    if (max_pq.empty() || val <= max_pq.top()) {
        max_pq.push(val);
    }
    else {
        min_pq.push(val);
    }

    if (max_pq.size() > min_pq.size() + 1) {
        min_pq.push(max_pq.top());
        max_pq.pop();
    }
    else if (min_pq.size() > max_pq.size()) {
        max_pq.push(min_pq.top());
        min_pq.pop();
    }

}

int getMedian() {
    return max_pq.top();
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;	cin >> N;

    for (int i = 0; i < N; i++) {
        int val;	cin >> val;
        calMedian(val);
        cout << getMedian() << "\n";
    }
}
