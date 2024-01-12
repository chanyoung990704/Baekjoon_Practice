#include <algorithm>
#include <iostream>
#include <vector>
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

vector<int> kmp(string s, string p) {
    vector<int> ans;
    auto pi = getPi(p);
    int n = (int)s.size(), m = (int)p.size(), j = 0;
    for (int i = 0; i < n; i++) {
        while (j > 0 && s[i] != p[j])
            j = pi[j - 1];
        if (s[i] == p[j]) {
            if (j == m - 1) {
                ans.push_back(i - m + 1);
                j = pi[j];
            }
            else {
                j++;
            }
        }
    }
    return ans;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    string p; cin >> p;
    int n; cin >> n;
    int ans = 0;
    for (int i = 0; i < n; i++) {
        string s; cin >> s;
        s += s; // 문자열의 시작과 끝이 연결된 형태로 문자가 새겨져 있으므로, 문자열을 두 번 붙여서 검색
        auto matched = kmp(s, p);
        if (matched.size() > 0) ans++;
    }
    cout << ans << '\n';
    return 0;
}
