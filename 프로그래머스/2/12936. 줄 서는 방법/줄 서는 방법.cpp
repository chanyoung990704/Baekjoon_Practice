#include <string>
#include <vector>
using namespace std;

vector<int> solution(int n, long long k) {
    vector<int> answer;
    vector<int> numbers;
    long long factorial = 1;

    // 초기 숫자 배열과 팩토리얼 계산
    for (int i = 1; i <= n; i++) {
        numbers.push_back(i);
        factorial *= i;
    }

    k--; // 0-based 인덱스로 변환

    for (int i = 0; i < n; i++) {
        factorial /= (n - i);
        int index = k / factorial;
        answer.push_back(numbers[index]);
        numbers.erase(numbers.begin() + index);
        k %= factorial;
    }

    return answer;
}
