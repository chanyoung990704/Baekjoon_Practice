#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
    sort(people.begin(), people.end());
    
    int cnt = 0; // Initialize boat count
    int left = 0, right = people.size() - 1; // Initialize pointers for heaviest and lightest people
    
    while (left <= right) {
        if (people[left] + people[right] <= limit) {
            left++; // Move the lighter person to the next boat
        }
        right--; // Move the heavier person to the next boat in any case
        cnt++; // Increment boat count
    }
    
    return cnt;
}
