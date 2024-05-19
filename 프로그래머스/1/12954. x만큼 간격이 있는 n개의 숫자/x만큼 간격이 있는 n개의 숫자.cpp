#include <string>
#include <vector>

using namespace std;

vector<long long> solution(int x, int n) {
    vector<long long> answer(n, 1);
    
    for(int i = 1 ; i <= n ; i++){
        answer[i - 1] = i * x;
    }
    
    return answer;
}