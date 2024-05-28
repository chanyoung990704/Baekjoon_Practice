#include <algorithm>
#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int T;  cin >> T;
    cin.ignore();

    for(int i = 0 ; i < T ; i++) {
        string s;
        getline(cin, s);

        vector<int> alphabets(26, 0);
        for(auto& c : s){
            if(isalpha(c)){
                alphabets[c - 'a']++;
            }
        }

        int max_val = *max_element(alphabets.begin(), alphabets.end());
        int idx = max_element(alphabets.begin(), alphabets.end()) - alphabets.begin();
        int cnt = count(alphabets.begin(), alphabets.end(), max_val);

        if(cnt > 1)
            cout << "?\n";
        else{
            char c = 'a' + idx;
            cout << c << "\n";
        } 

    }
    

}