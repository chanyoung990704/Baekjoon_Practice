#include <iostream>
#include <vector>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    vector<int> students(n, 1); // 학생들의 체육복 상태를 나타내는 벡터 생성

    // 체육복을 도난당한 학생들의 체육복 상태를 업데이트
    for (int l : lost) {
        students[l - 1]--;
    }

    // 여벌의 체육복을 가져온 학생들의 체육복 상태를 업데이트
    for (int r : reserve) {
        students[r - 1]++;
    }

    // 체육복을 빌려주는 과정
    for (int i = 0; i < n; i++) {
        if (students[i] == 0) {
            if (i > 0 && students[i - 1] == 2) {
                students[i]++;
                students[i - 1]--;
            }
            else if (i < n - 1 && students[i + 1] == 2) {
                students[i]++;
                students[i + 1]--;
            }
        }
    }

    // 체육복을 가진 학생의 수를 세어 반환
    int count = 0;
    for (int s : students) {
        if (s > 0) count++;
    }
    return count;
}