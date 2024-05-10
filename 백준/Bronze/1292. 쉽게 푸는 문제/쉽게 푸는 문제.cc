#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int A, B;  cin >> A >> B;

    vector<int> num_arr;

    int cur_idx = 1;

    while(true) {

        for(int i = 1 ; i <= cur_idx ; i++) {
            num_arr.push_back(cur_idx);
        }

        if(num_arr.size() > 1000)
            break;

        cur_idx++;
    }


    // 구간합 만들기
    vector<int> num_sum(1001, 0);
    for(int i = 1 ; i <= 1000 ; i++)
        num_sum[i] = num_sum[i - 1] + num_arr[i - 1];


    int result = num_sum[B] - num_sum[A - 1];
    cout << result << '\n';
    
}