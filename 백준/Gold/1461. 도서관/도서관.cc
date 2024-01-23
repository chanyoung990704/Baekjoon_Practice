#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;  cin >> N; // 책의 개수
    int M;  cin >> M; // 한번에 들 수 있는 책의 개수

    priority_queue<int> minusDistance; // 음수 좌표 입력받아 양수로 바꾼 후 저장
    priority_queue<int> distance; // 양수 좌표 

    for (int i = 0; i < N; i++)
    {
        int idx;    cin >> idx;
        if (idx < 0)
            minusDistance.push(-idx);
        else
            distance.push(idx);
    }
    
    bool whatMax = false; // 0이면 마이너스 최대 좌표 > +최대 좌표, 1이면 마이너스 최대 좌표 < +최대 좌표
    
    if (minusDistance.empty() && !distance.empty()) { // 마이너스 좌표가 없는 경우
        whatMax = true;
    }
    else if (!minusDistance.empty() && distance.empty()) { // +좌표가 없는 경우
        whatMax = false;
    } else if(minusDistance.top() > distance.top()) { // -좌표 최대값이 더 큰경우
        whatMax = false;
    }
    else
        whatMax = true;

    int result = 0;
    if (!whatMax) { // 마이너스 쪽이 최대 좌표 가질 경우
        result += minusDistance.top();

        for (int i = 0; i < M; i++)
            if (!minusDistance.empty())
                minusDistance.pop();

        int tmp = 0;
        int cnt = M;

        while (!minusDistance.empty())
        {
            if (cnt == M)
                tmp += minusDistance.top();

            minusDistance.pop();
            cnt--;

            if (cnt == 0)
                cnt = M;
        }

        cnt = M;
        while (!distance.empty())
        {
            if (cnt == M)
                tmp += distance.top();

            distance.pop();
            cnt--;

            if (cnt == 0)
                cnt = M;
        }

        result += 2 * tmp;
    }
    else { // +쪽이 최대 좌표 가질 경우
        result += distance.top();

        for (int i = 0; i < M; i++)
            if (!distance.empty())
                distance.pop();

        int tmp = 0;
        int cnt = M;

        while (!minusDistance.empty())
        {
            if (cnt == M)
                tmp += minusDistance.top();

            minusDistance.pop();
            cnt--;

            if (cnt == 0)
                cnt = M;
        }

        cnt = M;
        while (!distance.empty())
        {
            if (cnt == M)
                tmp += distance.top();

            distance.pop();
            cnt--;

            if (cnt == 0)
                cnt = M;

        }
        result += 2 * tmp;

    }

    cout << result << "\n";

}
