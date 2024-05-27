#include <vector>

using namespace std;

vector<int> solution(int n, long long left, long long right) {
    vector<int> answer;
    answer.reserve(right - left + 1); // 미리 메모리 할당

    for (long long i = left; i <= right; ++i) {
        int row = i / n;
        int col = i % n;
        answer.push_back(max(row, col) + 1);
    }

    return answer;
}