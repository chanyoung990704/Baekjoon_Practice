#include <iostream>
#include <stdio.h>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> d, int budget) {
    int answer = 0;
    
    sort(d.begin(), d.end());
    int cur_cost = 0;
    
    for(int i = 0 ; i < d.size() ; i++){
        
       if(cur_cost + d[i] <= budget){
           cur_cost += d[i];
           answer++;
           continue;
       } else{
           break;
       }
        
    }
    
    
    return answer;
}