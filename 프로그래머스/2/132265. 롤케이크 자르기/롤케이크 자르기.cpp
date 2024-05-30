#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(vector<int> topping) {
    int answer = 0;
        
    unordered_map<int, int> topping_1;
    unordered_map<int, int> topping_2;

    for(auto& t : topping)
        topping_2[t]++;

    for(int i = 0 ; i < topping.size() - 1 ; i++) {
        // 자르기 1
        topping_1[topping[i]]++;
        topping_2[topping[i]]--;
        
        if(topping_2[topping[i]] == 0)
            topping_2.erase(topping[i]);

        if(topping_1.size() == topping_2.size())
            answer++;

    }   
    
    
    return answer;
}