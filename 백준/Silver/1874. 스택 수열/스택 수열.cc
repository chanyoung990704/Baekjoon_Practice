#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int main() {
    int n;
    cin >> n;

    vector<int> sequence(n);
    for (int i = 0; i < n; ++i) {
        cin >> sequence[i];
    }

    stack<int> st;
    vector<char> result;

    int current = 1; // 스택에 넣을 다음 숫자
    for (int i = 0; i < n; ++i) {
        // 스택이 비어있거나 스택의 top 값이 수열의 현재 값과 다를 때
        while (st.empty() || st.top() != sequence[i]) {
            // 현재 값을 스택에 넣음
            st.push(current++);
            result.push_back('+');
            // 만약 현재 값이 주어진 수열의 값과 다르다면 더 이상 진행할 필요가 없으므로 break
            if (current > n + 1) {
                cout << "NO" << endl;
                return 0;
            }
        }
        // 수열의 값과 스택의 top 값이 같을 때
        if (st.top() == sequence[i]) {
            // 스택에서 값을 빼고 결과에 '-' 추가
            st.pop();
            result.push_back('-');
        }
    }

    // 결과 출력
    for (char c : result) {
        cout << c << '\n';
    }

    return 0;
}
