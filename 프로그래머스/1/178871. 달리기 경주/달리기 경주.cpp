#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

vector<string> solution(vector<string> players, vector<string> callings) {
    unordered_map<string, int> player_indices;
    for (int i = 0; i < players.size(); ++i) {
        player_indices[players[i]] = i;
    }

    for (auto& calling : callings) {
        int idx = player_indices[calling];
        if (idx > 0) {
            swap(players[idx - 1], players[idx]);
            player_indices[players[idx]] = idx;
            player_indices[players[idx - 1]] = idx - 1;
        }
    }
    
    return players;
}
