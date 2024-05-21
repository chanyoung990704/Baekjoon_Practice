#include <vector>
#include <iostream>
#include <math.h>
using namespace std;

vector<bool> get_prime(int n){
    vector<bool> prime(n + 1, true);
    prime[0] = false;
    prime[1] = false;
    
    for(int i = 2 ; i <= sqrt(n) ; i++)
        if(prime[i])
            for(int j = i * i ; j <= n ; j += i)
                prime[j] = false;
    
    return prime;
}

int solution(vector<int> nums) {
    int answer = 0;
    
    vector<bool> prime = get_prime(3000);
    int sum = 0;
    for(int i = 0 ; i < nums.size() - 2 ; i++)
        for(int j = i + 1 ; j < nums.size() - 1 ; j++)
            for(int k = j + 1 ; k < nums.size() ; k++) {
                sum = nums[i] + nums[j] + nums[k];
                if(prime[sum])
                    answer++;
            }
                
    
    return answer;
}