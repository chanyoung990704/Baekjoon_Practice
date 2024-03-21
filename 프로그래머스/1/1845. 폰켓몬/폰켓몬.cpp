#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

int solution(vector<int> nums) {
    int n = nums.size() / 2;
    unordered_set<int> types;

    for (int num : nums) {
        types.insert(num);
        if (types.size() == n) // If we reach the maximum capacity
            break;
    }

    return types.size(); // Return the number of unique types
}