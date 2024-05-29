#include <algorithm>
#include <iostream>
#include <vector>
#include <string>

using namespace std;

bool isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    while (true) {
        string s;
        cin >> s;

        if (s == "end")
            break;

        char prev = '\0'; // 초기화
        int s_idx = 0;
        bool acceptable = true;
        bool has_vowel = false;
        int vowel_cnt = 0;
        int not_vowel_cnt = 0;

        while (s_idx < s.size()) {
            char cur = s[s_idx];
            if (isVowel(cur)) {
                has_vowel = true;
                vowel_cnt++;
                not_vowel_cnt = 0;
            } else {
                vowel_cnt = 0;
                not_vowel_cnt++;
            }

            if (s_idx > 0 && prev == cur && cur != 'e' && cur != 'o') // 첫 번째 문자는 비교하지 않도록 수정
                acceptable = false;

            if (vowel_cnt == 3 || not_vowel_cnt == 3)
                acceptable = false;

            prev = cur;
            s_idx++;
        }

        if (!has_vowel)
            acceptable = false;

        if (acceptable)
            cout << "<" << s << "> is acceptable.\n";
        else
            cout << "<" << s << "> is not acceptable.\n";
    }
}