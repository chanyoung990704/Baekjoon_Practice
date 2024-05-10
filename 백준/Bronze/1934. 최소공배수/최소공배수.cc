#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int getGCD(int num1, int num2){
    if(num2 == 0)
        return num1;

    return getGCD(num2, num1 % num2);
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;  cin >> T;
    for(int test_case = 1; test_case <= T; ++test_case) {

        int num1, num2;  cin >> num1 >> num2;
        cout << num1 * num2 / getGCD(num1, num2) << "\n";

    }   
}