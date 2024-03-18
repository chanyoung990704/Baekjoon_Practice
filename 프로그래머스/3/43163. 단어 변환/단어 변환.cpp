#include <iostream>
#include <string>
#include <vector>
#include <unordered_set>
#include <queue>
#include <tuple>
#include <map>

using namespace std;

int ladderLength(string beginWord, string endWord, vector<string>& wordList) {

    // set으로 대체
    unordered_set<string> us(wordList.begin(), wordList.end());
    // 단어가 존재하지 않을 경우
    if (us.find(endWord) == us.end()) {
        return 0;
    }

    // 단어가 존재할 경우 bfs
    map<string, bool> visited;
    queue<tuple<string, int>> q;
    visited[beginWord] = true;
    q.push(make_tuple(beginWord, 0));

    while (!q.empty()) {
        string curWord = get<0>(q.front()); int cnt = get<1>(q.front());
        q.pop();

        if (curWord == endWord)
            return cnt;

        for (int i = 0; i < wordList.size(); i++) {
            // 방문하지 않고
            if (!visited[wordList[i]]) {
                int diff = 0;
                // 한글자만 다르다면 큐에 집어넣는다.
                for (int j = 0; j < curWord.size(); j++) {
                    if (curWord[j] != wordList[i][j])
                        diff++;
                }
                if (diff == 1) {
                    visited[wordList[i]] = true;
                    q.push(make_tuple(wordList[i], cnt + 1));
                }
            }
        }

    }

    return 0;
}

int solution(string begin, string target, vector<string> words) {

    int ret = ladderLength(begin, target, words);
    return ret;
}