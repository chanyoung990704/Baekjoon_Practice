#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<string> wallpaper) {
    vector<int> answer;
    
    int min_x = 1e9, min_y = 1e9;
    int max_x = -1, max_y = -1;
    
    for(int i = 0 ; i < wallpaper.size() ; i++)
        for(int j = 0 ; j < wallpaper[i].size(); j++)
            if(wallpaper[i][j] == '#'){
                min_x = min(min_x, j);
                max_x = max(max_x, j);
                min_y = min(min_y, i);
                max_y = max(max_y ,i);
            }

    answer.push_back(min_y);
    answer.push_back(min_x);
    answer.push_back(max_y + 1);
    answer.push_back(max_x + 1);
    
    return answer;
}