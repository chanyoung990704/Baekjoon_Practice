#include <iostream>
#include <queue>
#include <vector>

using namespace std;

priority_queue<int> maxHeap; // 최대 힙
priority_queue<int, vector<int>, greater<int>> minHeap; // 최소 힙

void addNumber(int number) {
    if (maxHeap.empty() || number <= maxHeap.top()) {
        maxHeap.push(number);
    }
    else {
        minHeap.push(number);
    }

    // 힙의 크기 조절
    if (maxHeap.size() > minHeap.size() + 1) {
        minHeap.push(maxHeap.top());
        maxHeap.pop();
    }
    else if (minHeap.size() > maxHeap.size()) {
        maxHeap.push(minHeap.top());
        minHeap.pop();
    }
}

int getMedian() {
    return maxHeap.top();
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    for (int i = 0; i < N; i++) {
        int val;
        cin >> val;
        addNumber(val);
        cout << getMedian() << "\n";
    }

    return 0;
}
