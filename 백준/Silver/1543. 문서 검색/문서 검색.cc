#include <algorithm>
#include <sstream>
#include <iostream>
#include <vector>
using namespace std;

vector<int> getPi(string p) {
    vector<int> pi(p.size(), 0);
    int j = 0;
    for (int i = 1; i < p.size(); i++) {
        while (j > 0 && p[i] != p[j]) {
            j = pi[j - 1];
        }
        if (p[i] == p[j]) {
            pi[i] = ++j;
        }
    }
    return pi;
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string sentence;    getline(cin, sentence);
    string pattern;     getline(cin, pattern);

    vector<int> pi = getPi(pattern);
    vector<int> result;
    int j = 0;

    for (int i = 0; i < sentence.size(); i++) {

        while (j > 0 && sentence[i] != pattern[j])
        {
            j = pi[j - 1];
        }

        if (sentence[i] == pattern[j]) {

            if (j == pattern.size() - 1) {
                result.push_back(i - j);
                j = 0;
            }
            else {
                j++;
            }


        }

    }


    cout << result.size() << "\n";

}
