#include <algorithm>
#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
 
    while(true){

        string s;
        getline(cin, s);

        if(s == "END")
            break;

        reverse(s.begin(), s.end());

        cout << s << "\n";


    }
    
}