#include <string>
#include <vector>

using namespace std;

int solution(vector<int> numbers) {
    int answer = 0;
    vector<bool> have_num(10, false);
    
    for(auto n : numbers)
        have_num[n] = true;
    
    for(int i = 0 ; i < 10 ; i++)
        if(!have_num[i])
            answer += i;
    
    return answer;
}