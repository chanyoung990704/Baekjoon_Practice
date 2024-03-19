#include <vector>
#include <set>

using namespace std;

int solution(int distance, vector<int> rocks, int n) {
    // Add the distance and rocks to a set
    set<int> setRock(rocks.begin(), rocks.end());
    setRock.insert(distance);
    
    int lo = 0;
    int hi = distance;
    int answer = 0;
    
    while (lo <= hi) {
        int mid = (lo + hi) / 2;
        int prev = 0;
        int removed = 0;
        bool isPossible = true;
        
        for (int rock : setRock) {
            if (rock - prev < mid) {
                removed++;
            } else {
                prev = rock;
            }
        }
        
        if (removed > n) {
            hi = mid - 1;
        } else {
            lo = mid + 1;
            answer = mid;
        }
    }
    
    return answer;
}
