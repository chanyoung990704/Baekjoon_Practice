#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    // 배열 순회
    for(int i = 0 ; i < arr.size() ; i++ ){
        int cur = arr[i];
        // 50보다 같거나 크다
        if(cur >= 50) {
            // 짝수이다
            if(cur % 2 == 0)
                cur /= 2;
        }else {
            // 홀수이다
            if(cur % 2 == 1)
                cur *= 2;
        }
        answer.push_back(cur);
    }
    
    return answer;
}