#include <string>
#include <vector>

using namespace std;

int solution(string num_str) {
    int answer = 0;
    for(auto n : num_str){
        int num = n - '0';
        answer += num;
    }
    return answer;
}