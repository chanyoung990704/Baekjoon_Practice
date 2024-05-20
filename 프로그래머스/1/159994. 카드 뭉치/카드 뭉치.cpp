#include <string>
#include <vector>

using namespace std;

string solution(vector<string> cards1, vector<string> cards2, vector<string> goal) {
    string answer = "";
    
    int idx1 = 0;
    int idx2 = 0;
    int idx_goal = 0;
    
    while(idx_goal < goal.size()){
        
        if(cards1[idx1] == goal[idx_goal] && idx1 < cards1.size()){
            idx1++;
            idx_goal++;
        }else if(cards2[idx2] == goal[idx_goal] && idx2 < cards2.size()){
            idx2++;
            idx_goal++;
        }else{
            answer.append("No");
            return answer;
        }
    }
    
    answer.append("Yes");
    return answer;
}