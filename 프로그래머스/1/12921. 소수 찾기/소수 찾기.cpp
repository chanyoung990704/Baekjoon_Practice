#include <string>
#include <vector>
#include <math.h>

using namespace std;

vector<bool> get_prime_v(int n) {
    vector<bool> primes(n + 1, true);
    primes[0] = false;
    primes[1] = false;
    
    for(int i = 2 ; i <= sqrt(n) ; i++)
        if(primes[i])
            for(int j = i * i ; j <= n ; j+=i)
                primes[j] = false;
    
    
    return primes;
}

int solution(int n) {
    int answer = 0;
    vector<bool> primes = get_prime_v(n);
    
    for(int i = 2 ; i <= n ; i++)
        if(primes[i])
            answer++;
    
    return answer;
}