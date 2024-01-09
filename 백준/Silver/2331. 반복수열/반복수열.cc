#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int Next(int a, int p) {
    int ret = 0;
    while (a > 0) {
        ret += pow(a % 10, p);
        a /= 10;
    }
    return ret;
}

int main() {
    int A, P;
    cin >> A >> P;

    vector<int> D(10000000, 0);
    D[A] = 1;

    int index = 2;
    int num = Next(A, P);
    while (D[num] == 0) {
        D[num] = index;
        num = Next(num, P);
        index++;
    }

    cout << D[num] - 1;

    return 0;
}
