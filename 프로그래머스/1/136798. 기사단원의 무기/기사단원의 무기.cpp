#include <string>
#include <vector>
#include <math.h>

using namespace std;

int solution(int number, int limit, int power) {
    
    int answer = 0;
    
    vector<int> d_num(number + 1, 1);
    
    for(int i = 2 ; i < d_num.size(); i++){
        for(int j = i; j <= d_num.size() ; j += i)
            d_num[j]++;
    }
    
    for(int i = 1 ; i <= number ; i++){
        if(d_num[i] > limit)
            answer += power;
        else
            answer += d_num[i];
    }
    
    return answer;
}