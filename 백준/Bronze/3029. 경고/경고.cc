#include <algorithm>
#include <iostream>
#include <iomanip>
#include <vector>
#include <string>
#include <sstream>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int h1, m1, s1;
    int h2, m2, s2;
    char c;

    cin >> h1 >> c >> m1 >> c >> s1;
    cin >> h2 >> c >> m2 >> c >> s2;

    int t1 = h1 * 3600 + m1 * 60 + s1;
    int t2 = h2 * 3600 + m2 * 60 + s2;

    int diff = t2 - t1;
    if(diff <= 0){
        diff += 24 * 3600;
    }

    int h = diff / 3600;
    diff %= 3600;
    int m = diff / 60;
    int s = diff % 60;

    cout << setw(2) << setfill('0') << h;
    cout << ":";
    cout << setw(2) << setfill('0') << m;
    cout << ":";
    cout << setw(2) << setfill('0') << s;

    
}