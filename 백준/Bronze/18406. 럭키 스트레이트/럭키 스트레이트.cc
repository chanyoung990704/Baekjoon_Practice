#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    

    int N;  cin >> N;

    string num = to_string(N);

    int lo = 0;
    int hi = num.size() - 1;

    int left_val = 0;
    int right_val = 0;

    while(lo <= hi) {
        left_val += (num[lo] - '0');
        right_val += (num[hi] - '0');

        lo++;
        hi--;
    }

    if(left_val == right_val)
        cout << "LUCKY\n";
    else
        cout << "READY\n";

}