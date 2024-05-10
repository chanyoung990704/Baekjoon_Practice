#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int max_val = -2000000000;
int min_val = 2000000000;

void bruteForce(vector<int>& num_arr, int idx, int plus, int minus, int mul, int div, int result) {

    // basecase
    if(idx == num_arr.size()) {
        max_val = max(max_val, result);
        min_val = min(min_val, result);
        return;
    }

    // backtracking
    if(plus > 0) {
        bruteForce(num_arr, idx + 1, plus - 1, minus, mul, div, result + num_arr[idx]);
    }
    if(minus > 0) {
        bruteForce(num_arr, idx + 1, plus, minus - 1, mul, div, result - num_arr[idx]);
    }  
    if(mul > 0) {
        bruteForce(num_arr, idx + 1, plus, minus, mul - 1, div, result * num_arr[idx]);
    }
    if(div > 0) {
        bruteForce(num_arr, idx + 1, plus, minus, mul, div - 1, result / num_arr[idx]);
    }  

}



int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N;  cin >> N;

    vector<int> num_arr(N);
    for(int i = 0 ; i <N ; i++)
      cin >> num_arr[i];

    vector<int> num_operations(4);
    for(int i = 0 ; i < 4 ; i++)
      cin >> num_operations[i];

    bruteForce(num_arr, 1, num_operations[0], num_operations[1], num_operations[2], num_operations[3], num_arr[0]);

    cout << max_val << '\n' << min_val;
    
}