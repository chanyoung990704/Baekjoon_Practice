#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<int> food) {
    string answer = "";
    
    string left = "";
    for(int i = 1 ; i < food.size() ; i++) {
        int cnt = food[i] / 2;
        for(int j = 0 ; j < cnt ; j++)
            left.append(to_string(i));
    }
    
    string right = left;
    reverse(right.begin(), right.end());
    
    answer = left + "0" + right;
    
    
    return answer;
}