#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> getPi(string p) {
    int m = (int)p.size(), j = 0;
    vector<int> pi(m, 0);
    for (int i = 1; i < m; i++) {
        while (j > 0 && p[i] != p[j])
            j = pi[j - 1];
        if (p[i] == p[j])
            pi[i] = ++j;
    }
    return pi;
}

int main() {
    string s;
    cin >> s;

    string rev_s = s;
    reverse(rev_s.begin(), rev_s.end());

    vector<int> pi = getPi(rev_s);
    int begin = 0, matched = 0, len = s.size();
    while (begin < len) {
        if (matched < len && s[begin + matched] == rev_s[matched]) {
            matched++;
            if (begin + matched == len) {
                break;
            }
        }
        else {
            if (matched == 0) {
                begin++;
            }
            else {
                begin += matched - pi[matched - 1];
                matched = pi[matched - 1];
            }
        }
    }

    cout << len + begin << endl;

    return 0;
}
