#include <string>
#include <vector>
#include <algorithm>
#include <cmath>
#include <sstream>

using namespace std;

bool isPrime(long long num) {
    if (num <= 1) return false;
    if (num == 2) return true;
    if (num % 2 == 0) return false;
    for (long long i = 3; i <= sqrt(num); i += 2) {
        if (num % i == 0) return false;
    }
    return true;
}

int solution(int n, int k) {
    int answer = 0;
    
    // 진수 변환
    string num;
    if (k == 10) {
        num = to_string(n);
    } else {
        while (n > 0) {
            int tmp = n % k;
            num.append(to_string(tmp));
            n /= k;
        }
        reverse(num.begin(), num.end());
    }
    
    // 0을 기준으로 분리하여 소수 판별
    stringstream ss(num);
    string token;
    vector<long long> v;
    
    while (getline(ss, token, '0')) {
        if (!token.empty()) {
            long long value = stoll(token);
            if (isPrime(value)) {
                answer++;
            }
        }
    }
    
    return answer;
}