#include <string>
#include <vector>

using namespace std;

int solution(vector<int> numbers, int n) {
    int answer = 0;
    // 누적합 구하기
    for(int i = 1; i < numbers.size() ; i++)
        numbers[i] += numbers[i - 1];
    
    // 누적합이 n보다 큰 거 찾기
    for(int i = 0 ; i < numbers.size() ; i++)
        if(numbers[i] > n){
            answer = numbers[i];
            break;
        }
    
    return answer;
}