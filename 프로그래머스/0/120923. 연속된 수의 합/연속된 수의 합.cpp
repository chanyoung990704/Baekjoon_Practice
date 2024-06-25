#include <string>
#include <vector>

using namespace std;

vector<int> solution(int num, int total) {
    vector<int> answer;
    
    int sum = 0;
    for(int i = -1000 ; i <= 1000 ; i++){
        for(int j = i ; j < i + num ; j++){
            sum += j;
            answer.push_back(j);     
        }
        if(sum == total)
            return answer;
        
        answer.clear();
        sum = 0;
    }
            
    
    return answer;
}