#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>

using namespace std;

const int MOD = 1000000007;

long long factorialMod(int n) {
    long long result = 1;
    for (int i = 2; i <= n; i++) {
        result = (result * i) % MOD;
    }

    return result;
}

long long modInverse(long long a, long long p) {
    long long result = 1;
    long long exponent = p - 2;
    while (exponent > 0) {
        if (exponent % 2 == 1)
            result = (result * a) % p;
        a = (a * a) % p;
        exponent /= 2;
    }
    return result;
}

long long solve(int n, int k) {
    long long numerator = factorialMod(n);
    long long denominator = factorialMod(k) * factorialMod(n - k) % MOD;
    return (numerator * modInverse(denominator, MOD)) % MOD;

}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, K; cin >> N >> K;
    cout << solve(N, K) << "\n";

}
