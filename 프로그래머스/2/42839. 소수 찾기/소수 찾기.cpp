#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
#include <set>

using namespace std;

void makeNum(vector<bool>& visited, string& numbers, string& cur, set<int>& nums) {
    
    //basecase
    if(!cur.empty()) {
        int n = stoi(cur);
        nums.insert(n);
    }
    
    for(int i = 0 ; i < numbers.size() ; i++)
        if(!visited[i]) {
            visited[i] = true;
            cur.push_back(numbers[i]);
            makeNum(visited, numbers, cur, nums);
            cur.pop_back();
            visited[i] = false;  
        }

}

int solution(string numbers) {

    int MAX = 10000000;
    vector<bool> isPrime(MAX, true);
    isPrime[0] = false; isPrime[1] = false;
    int sqrtn = int(sqrt(MAX));
    for(int i = 2 ; i <= sqrtn ; i++) {
        if(isPrime[i])
            for(int j = i * i ; j <= MAX ; j += i)
                isPrime[j] = false;
    }

    vector<bool> visited(numbers.size(), false);
    set<int> nums;
    string cur = "";
    makeNum(visited, numbers, cur, nums);
    
    int ret = 0;
    for(auto n : nums)
        if(isPrime[n])
            ret++;
    
    return ret;
}