#include <algorithm>
#include <iostream>
#include <vector>
#include <math.h>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n;  cin >> n;

    if(n % 4 == 0 && (n % 100 != 0 || n % 400 == 0))
        cout << 1 << '\n';
    else
        cout << 0 << "\n";

}