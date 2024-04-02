#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>
#include <string>

using namespace std;

void topologicalSort(vector<vector<int>>& adj, vector<int>& indegree, vector<bool>& isIt) {
    queue<int> q;
    string result = "";
    bool isPossible = true;

    for (int i = 0; i < 26; i++) {
        if (indegree[i] == 0 && isIt[i]) {
            q.push(i);
        }
    }

    while (!q.empty()) {
        if (q.size() > 1) {
            isPossible = false; // 가능한 순서가 2개 이상일 때
        }

        int cur = q.front(); q.pop();
        result.push_back(cur + 'a');

        for (int i = 0; i < 26; i++) {
            if (adj[cur][i] == 1) {
                if (--indegree[i] == 0) {
                    q.push(i);
                }
            }
        }
    }

    // 출력
    if (result.size() != count(isIt.begin(), isIt.end(), true)) {
        cout << "!";
    }
    else {
        if (isPossible) {
            cout << result;
        }
        else {
            cout << "?";
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N; cin >> N;
    vector<string> words(N);
    for (int i = 0; i < N; i++) {
        cin >> words[i];
    }

    vector<bool> isIt(26, false);
    for (const string& word : words) {
        for (char c : word) {
            isIt[c - 'a'] = true;
        }
    }

    vector<vector<int>> adj(26, vector<int>(26, 0));
    vector<int> indegree(26, 0);
    bool notValid = false;

    for (int i = 0; i < N - 1; i++) {
        const string& word1 = words[i];
        const string& word2 = words[i + 1];
        bool found = false;

        for (int j = 0; j < min(word1.size(), word2.size()); j++) {
            if (word1[j] != word2[j]) {
                int u = word1[j] - 'a';
                int v = word2[j] - 'a';

                if (adj[u][v] == 0) {
                    adj[u][v] = 1;
                    indegree[v]++;
                }
                found = true;
                break;
            }
        }

        if (!found && word1.size() > word2.size()) {
            notValid = true;
            break;
        }
    }

    if (notValid) {
        cout << "!";
    }
    else {
        topologicalSort(adj, indegree, isIt);
    }

    return 0;
}
