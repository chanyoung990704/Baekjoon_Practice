#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    
    int start_y = -1;
    int start_x = -1;
    
    for(int i = 0 ; i < park.size() ; i++){
        for(int j = 0 ; j < park[i].size() ;j++)
            if(park[i][j] == 'S'){
                start_y = i;
                start_x = j;
                break;
            }
        if(start_y >= 0 && start_x >= 0)
            break;
    }
    
    
    for(auto& route : routes){
        char op = route[0];
        int n = route[2] - '0';
        int tmp_x = start_x;
        int tmp_y = start_y;
        bool isPossible = true;
        for(int i = 0 ; i < n ; i++){
            
            if(op == 'E'){
                tmp_x += 1;
            }else if(op == 'W'){
                tmp_x -= 1;
            }else if(op == 'S'){
                tmp_y += 1;
            }else{
                tmp_y -= 1;
            }
            
            if(tmp_y >= 0 && tmp_y < park.size() && tmp_x >= 0 
               && tmp_x < park[0].size()){
                
            }else{
                isPossible = false;
            }
            
            if(isPossible)
                if(park[tmp_y][tmp_x] == 'X')
                    isPossible = false;
            
            if(!isPossible)
                break;
        }
        
        if(isPossible){
            start_y = tmp_y;
            start_x = tmp_x;
        }
        
    }
    
    
    answer.push_back(start_y);
    answer.push_back(start_x);
    
    return answer;
}