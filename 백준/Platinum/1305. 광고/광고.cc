#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

vector<int> get_failure_function(string& s){

    vector<int> arr(s.size(), 0);
    int j = 0;

    for(int i = 1 ; i < s.size() ; i++){
        while(j > 0 && s[i] != s[j])
            j = arr[j - 1];

        if(s[i] == s[j]){
            arr[i] = j + 1;
            j++;
        }

    }

    return arr;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int L;  cin >> L;
    string s;   cin >> s;


    vector<int> failure_arr = get_failure_function(s);

    cout << s.size() - failure_arr.back() << "\n";

}