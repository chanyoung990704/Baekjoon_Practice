#include <iostream>
#include <vector>
#include <string>
using namespace std;

bool isPalindrome(const string& str) {
    int left = 0;
    int right = str.length() - 1;
    while (left < right) {
        if (str[left] != str[right]) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}

bool dfs(vector<string>& words, vector<bool>& visited, string& result, int cnt) {
    if (cnt == 2) { // 2개의 단어를 선택했을 때
        if (isPalindrome(result)) { // 팰린드롬인지 확인
            return true;
        }
        return false;
    }

    for (int i = 0; i < words.size(); i++) {
        if (!visited[i]) {
            visited[i] = true;
            string before = result; // 현재 결과를 백업
            result += words[i]; // 선택한 단어 추가
            if (dfs(words, visited, result, cnt + 1)) { // 재귀적으로 DFS 호출
                return true;
            }
            result = before; // 원래 상태로 되돌림
            visited[i] = false;
        }
    }

    return false;
}

int main() {
    int T;
    cin >> T;
    while (T--) {
        int k;
        cin >> k;
        vector<string> words(k);
        for (int i = 0; i < k; ++i) {
            cin >> words[i];
        }

        vector<bool> visited(k, false);
        string result;
        bool found = false;

        for (int i = 0; i < k; ++i) {
            visited[i] = true;
            result = words[i];
            if (dfs(words, visited, result, 1)) {
                found = true;
                cout << result << "\n";
                break;
            }
            visited[i] = false;
        }

        if (!found) {
            cout << "0\n";
        }
    }
    return 0;
}
