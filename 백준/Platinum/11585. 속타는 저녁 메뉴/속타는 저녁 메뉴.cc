#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int get_gcd(int a, int b){
    if(b == 0)
        return a;

    return get_gcd(b, a % b);
}

vector<int> get_fail_function(string& pattern) {

    int p = pattern.size();
    vector<int> fail(p, 0);
    int j = 0;

    for(int i = 1 ; i < p ; i++) {

        // 불일치
        while(j > 0 && pattern[i] != pattern[j])
            j = fail[j - 1];

        // 일치
        if(pattern[i] == pattern[j]){
            fail[i] = j + 1;
            j++;
        }

    }

    return fail;

}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N;  cin >> N;

    string pattern;
    for(int i = 0 ; i < N ; i++){
        char c; cin >> c;
        pattern.push_back(c);
    }

    string text;
    for(int i = 0 ; i < N ; i++) {
        char c; cin >> c;
        text.push_back(c);
    }

    text = text + text;
    text.pop_back();

    int cnt = 0;
    // KMP
    vector<int> fail = get_fail_function(pattern);

        int i = 0, j = 0;
        int t = text.size();
        int p = pattern.size();

        while(i < t) {

            // 불일치
            while(j > 0 && text[i] != pattern[j])
                j = fail[j - 1];

            // 일치
            if(text[i] == pattern[j])
                j++;

            if(j == p){
                cnt++;
                j = fail[j - 1];
            }

            i++;
        }


    int gcd = get_gcd(N, cnt);

    cout << cnt / gcd << "/" << N / gcd << "\n";
}