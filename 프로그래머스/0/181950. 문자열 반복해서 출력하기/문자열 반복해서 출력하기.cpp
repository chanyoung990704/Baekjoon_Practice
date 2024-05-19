#include <iostream>
#include <string>

using namespace std;

int main(void) {
    string str;
    int n;
    cin >> str >> n;
    
    string result = "";
    for(int i = 0 ; i < n ; i++)
        result.append(str);
    
    cout << result << "\n";
    return 0;
}