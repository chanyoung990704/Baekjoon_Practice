#include <iostream>
#include <vector>
#include <stack>

using namespace std;

long long solution(int cap, int n, vector<int> deliveries, vector<int> pickups) {
    long long answer = 0;
    stack<int> deliveryIdx, pickupIdx;

    for (int i = 0; i < n; ++i) {
        if (deliveries[i] != 0)
            deliveryIdx.push(i + 1);
        if (pickups[i] != 0)
            pickupIdx.push(i + 1);
    }

    while (!deliveryIdx.empty() || !pickupIdx.empty()) {
        if (!deliveryIdx.empty() && pickupIdx.empty())
            answer += deliveryIdx.top() * 2;
        else if (deliveryIdx.empty() && !pickupIdx.empty())
            answer += pickupIdx.top() * 2;
        else if (deliveryIdx.top() <= pickupIdx.top())
            answer += pickupIdx.top() * 2;
        else
            answer += deliveryIdx.top() * 2;

        int curCap = cap;

        while (!deliveryIdx.empty() && curCap != 0) {
            int curIdx = deliveryIdx.top();
            if (deliveries[curIdx - 1] <= curCap) {
                curCap -= deliveries[curIdx - 1];
                deliveryIdx.pop();
            }
            else {
                deliveries[curIdx - 1] -= curCap;
                break;
            }
        }

        curCap = cap;

        while (!pickupIdx.empty() && curCap != 0) {
            int curIdx = pickupIdx.top();
            if (pickups[curIdx - 1] <= curCap) {
                curCap -= pickups[curIdx - 1];
                pickupIdx.pop();
            }
            else {
                pickups[curIdx - 1] -= curCap;
                break;
            }
        }
    }
    return answer;
}