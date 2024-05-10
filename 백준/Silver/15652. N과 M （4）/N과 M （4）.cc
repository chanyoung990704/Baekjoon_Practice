#include <iostream>
#include <vector>
using namespace std;

int n, m;
vector<int> seq;

void backtrack(int idx) {
    // basecase
    if(seq.size() == m){
        for(int num : seq) cout << num << " ";
        cout << "\n";
        return;
    }

    for(int i = idx ; i <= n ; i++) {
        seq.push_back(i);
        backtrack(i);
        seq.pop_back();
    }
    return;
}

int main() {
    cin >> n >> m;
    backtrack(1);
    return 0;
}