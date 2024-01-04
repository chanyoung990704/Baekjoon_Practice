#include <vector>
#include <queue>
#include <tuple>

using namespace std;

bool isChange(const string& a, const string& b) {
    int cnt = 0;
    for (int i = 0; i < a.size(); i++) {
        if (a[i] != b[i])
            cnt++;
        if (cnt > 1)
            return false;
    }

    return cnt == 1;
}


int solution(string begin, string target, vector<string> words) {
    int answer = 0;
    queue<tuple<string, int>> q;
    vector<bool> visited(words.size(), false);
    q.push(make_tuple(begin, 0));

    while (!q.empty()) {
        string curWord = get<0>(q.front());
        int cnt = get<1>(q.front());
        q.pop();

        if (curWord == target)
            return cnt;

        for (int i = 0; i < words.size(); i++) {
            string word = words[i];
            if (isChange(word, curWord) && !visited[i]) {
                q.push(make_tuple(word, cnt + 1));
                visited[i] = true;
            }

        }


    }

    return answer;
}