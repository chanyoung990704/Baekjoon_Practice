#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> prices) {
    
    vector<int> result;
    
    // 이중 반복문 구현
    for(int i = 0 ; i < prices.size() ; i++) {
        int sec = 0; // 경과 시점
        for(int j = i + 1 ; j < prices.size() ; j++) {
            // 가격이 떨어지지 않았을 경우
            if(prices[i] <= prices[j]) {
                // 경과 시점 증가
                sec++;
            }
            else {
                sec++;
                break;
            }
        }
        result.push_back(sec);
    }
    
    return result;
}