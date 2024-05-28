#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    

    int strokes[26] = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};

    string s;   cin >> s;

    vector<int> scores;
    for(auto& c : s) {
        scores.push_back(strokes[c - 'A']);
    }


    while(scores.size() > 1) {
        vector<int> tmp;
        for(int i = 0 ; i < scores.size() ; i += 2){
            if(i + 1 < scores.size()){
                tmp.push_back((scores[i] + scores[i + 1]) % 10);
            }else{
                tmp.push_back(scores[i]);
            }

        }
        scores = tmp;
    }

    if(scores[0] % 2 == 0){
        cout << "You're the winner?\n";
    }else{
        cout << "I'm a winner!\n";
    }

}