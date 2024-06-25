#include <vector>
using namespace std;

// 두 점 (x1, y1), (x2, y2)를 잇는 직선의 기울기를 계산하는 함수
double calculateSlope(pair<int, int> p1, pair<int, int> p2) {
    return static_cast<double>(p2.second - p1.second) / (p2.first - p1.first);
}

int solution(vector<vector<int>> dots) {
    // 네 점을 쌍으로 묶어서 기울기를 비교
    pair<int, int> p1 = {dots[0][0], dots[0][1]};
    pair<int, int> p2 = {dots[1][0], dots[1][1]};
    pair<int, int> p3 = {dots[2][0], dots[2][1]};
    pair<int, int> p4 = {dots[3][0], dots[3][1]};
    
    // 네 점을 두 개씩 이은 네 가지 경우의 기울기를 비교
    // (p1, p2)와 (p3, p4)
    if (calculateSlope(p1, p2) == calculateSlope(p3, p4)) return 1;
    // (p1, p3)와 (p2, p4)
    if (calculateSlope(p1, p3) == calculateSlope(p2, p4)) return 1;
    // (p1, p4)와 (p2, p3)
    if (calculateSlope(p1, p4) == calculateSlope(p2, p3)) return 1;
    
    // 어떤 경우에도 평행하지 않으면 0을 반환
    return 0;
}
