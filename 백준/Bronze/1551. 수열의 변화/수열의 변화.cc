#include <algorithm>
#include <iostream>
#include <vector>
#include <sstream>

using namespace std;

int main() {

    int N, K;
    cin >> N >> K;

    cin.ignore();
    string number_input;
    getline(cin, number_input);

    stringstream ss(number_input);
    string token;
    vector<int> nums;
    while(getline(ss, token, ',')){
        nums.push_back(stoi(token));
    }

    int cnt = 0;
    int nums_size = N;

    while(cnt < K) {
        cnt++;

        for(int i = 0 ; i < nums_size - 1 ; i++) {
            nums[i] = nums[i+1] - nums[i];
        }

        nums_size--;

    }

    for(int i = 0 ; i < nums_size - 1 ; i++) {
        cout << nums[i] << ",";
    }
    cout << nums[nums_size-1] << "\n";

}