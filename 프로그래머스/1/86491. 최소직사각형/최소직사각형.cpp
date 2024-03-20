#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> sizes) {
    int maxWeight = 0, maxHeight = 0;
    for (const auto& size : sizes) {
        maxWeight = max(maxWeight, max(size[0], size[1]));
        maxHeight = max(maxHeight, min(size[0], size[1]));
    }
    return maxWeight * maxHeight;
}
