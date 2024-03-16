#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> A, vector<int> B) {
    int answer = 0;
    
    // 배열 A와 B를 오름차순으로 정렬
    sort(A.begin(), A.end());
    sort(B.begin(), B.end());
    
    // 배열 A와 B의 각 요소를 순차적으로 곱하여 누적된 값 계산
    for (int i = 0; i < A.size(); ++i) {
        answer += A[i] * B[A.size() - 1 - i]; // B는 내림차순으로 사용
    }
    
    return answer;
}