#include <string>
#include <vector>
#include <map>

using namespace std;

int solution(vector<vector<int>> lines) {
    int answer = 0;
    
    map<pair<int, int>, int> um;
    
    for(auto& line : lines){
        for(int i = line[0] ; i < line[1] ; i++)
            um[make_pair(i, i + 1)]++;
    }
    
    for(auto& m : um)
        if(m.second > 1)
            answer++;
    
    return answer;
}