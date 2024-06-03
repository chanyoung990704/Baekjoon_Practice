#include <string>
#include <vector>
#include <unordered_map>
#include <sstream>

using namespace std;

vector<string> solution(vector<string> record) {
    vector<string> answer;
    unordered_map<string, string> user_id_map;
    
    for(auto& cur : record) {
        stringstream ss(cur);
        string op, id, nickname;
        ss >> op >> id;
        
        if (op != "Leave") {
            ss >> nickname;
            user_id_map[id] = nickname;
        }
    }
    
    for(auto& cur : record) {
        stringstream ss(cur);
        string op, id;
        ss >> op >> id;
        
        if (op == "Enter") {
            answer.push_back(user_id_map[id] + "님이 들어왔습니다.");
        } else if (op == "Leave") {
            answer.push_back(user_id_map[id] + "님이 나갔습니다.");
        }
    }
    
    return answer;
}