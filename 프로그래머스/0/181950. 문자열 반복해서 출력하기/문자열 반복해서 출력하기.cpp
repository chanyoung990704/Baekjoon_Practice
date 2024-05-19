#include <iostream>
#include <string>

using namespace std;

int main(void) {
    string str;
    int n;
    cin >> str >> n;
    string tmp = str;
    for(int i = 1 ; i < n ; i++)
        str = str + tmp;
    cout << str;
    return 0;
}