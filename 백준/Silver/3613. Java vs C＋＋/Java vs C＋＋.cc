#include <iostream>
#include <string>
#include <cctype>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string word; cin >> word;
    bool isC = false, isJava = false, error = false;

    if (word.empty() || isupper(word[0]) || word[0] == '_' || word[word.size() - 1] == '_') {
        error = true;
    }

    for (size_t i = 0; i < word.size() && !error; ++i) {
        if (word[i] == '_') {
            if (isJava || i + 1 == word.size() || word[i + 1] == '_') {
                error = true;
                break;
            }
            isC = true;
        }
        else if (isupper(word[i])) {
            if (isC) {
                error = true;
                break;
            }
            isJava = true;
        }
    }

    if (error) {
        cout << "Error!" << endl;
        return 0;
    }

    if (isC) {
        for (size_t i = 0; i < word.size(); ++i) {
            if (word[i] == '_') {
                word.erase(i, 1);
                word[i] = toupper(word[i]);
            }
        }
    }
    else if (isJava) {
        for (size_t i = 0; i < word.size(); ++i) {
            if (isupper(word[i])) {
                word.insert(i, "_");
                word[i + 1] = tolower(word[i + 1]);
                ++i;
            }
        }
    }

    cout << word << endl;
    return 0;
}
