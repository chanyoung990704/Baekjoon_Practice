#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

vector<int> get_failure_function(string pattern) {

    int max_size = pattern.size();
    vector<int> failure_function(max_size, 0);
    int j = 0;

    for(int i  = 1; i < max_size ; i++) {

        // 불일치
        while(j > 0 && pattern[i] != pattern[j]) {
            j = failure_function[j - 1];
        }

        // 일치
        if(pattern[i] == pattern[j]){
            failure_function[i] = j + 1;
            j++;
        }

    }

    return failure_function;

}

vector<int> kmp_search(string text, string pattern) {
    vector<int> failure_function = get_failure_function(pattern);
    vector<int> result;
    int n = text.length();
    int m = pattern.length();
    int j = 0;

    for(int i = 0; i < n; i++) {
        while(j > 0 && text[i] != pattern[j]) {
            j = failure_function[j - 1];
        }
        if(text[i] == pattern[j]) {
            j++;
        }
        if(j == m) {
            result.push_back(i - m + 1);
            j = failure_function[j - 1];
        }
    }

    return result;
}



int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string S, P;    cin >> S >> P;

    vector<int> result = kmp_search(S, P);

    if(result.size() == 0)
        cout << 0 << "\n";
    else
        cout << 1 << "\n";
    
}