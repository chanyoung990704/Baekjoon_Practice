#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N, M;
    cin >> M >> N;

    priority_queue<int, vector<int>, greater<int>> result;

    int max_num = N;

    // 소수 체 만들기
    vector<bool> isPrime(max_num + 1, true);
    isPrime[0] = false; isPrime[1] = false;
    for(int i = 2; i <= max_num; i++)
        if(isPrime[i])
            for(int j = i * i ; j <= max_num ; j += i)
                isPrime[j] = false;

    
    int sum = 0;

    for(int i = M ; i <= N ; i++)
        if(isPrime[i]){
            result.push(i);
            sum += i;
        }


    if(result.empty())
        cout << -1 << "\n";
    else{
        cout << sum << "\n";
        cout << result.top() << "\n";
    }
}