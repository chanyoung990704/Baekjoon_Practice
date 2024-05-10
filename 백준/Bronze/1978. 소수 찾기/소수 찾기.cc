#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N;
    cin >> N;

    vector<int> result;
    vector<int> num_arr(N);

    for(int i = 0 ; i < N ; i++){
        cin >> num_arr[i];
    }

    int max_num = *max_element(num_arr.begin(), num_arr.end());

    // 소수 체 만들기
    vector<bool> isPrime(max_num + 1, true);
    isPrime[0] = false; isPrime[1] = false;
    for(int i = 2; i <= max_num; i++)
        if(isPrime[i])
            for(int j = i * i ; j <= max_num ; j += i)
                isPrime[j] = false;

    
    for(auto num : num_arr)
        if(isPrime[num])
            result.push_back(num);

    cout << result.size() << "\n";
}