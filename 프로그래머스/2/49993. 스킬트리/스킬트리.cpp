#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(string skill, vector<string> skill_trees) {
    unordered_map<char, int> skill_map;
    for (int i = 0; i < skill.size(); i++) {
        skill_map[skill[i]] = i;
    }

    int ret = 0;

    for (auto& skill_tree : skill_trees) {
        int last_skill_index = -1;
        bool isPossible = true;

        for (char cur : skill_tree) {
            if (skill_map.find(cur) != skill_map.end()) {
                if (skill_map[cur] == last_skill_index + 1) {
                    last_skill_index++;
                } else {
                    isPossible = false;
                    break;
                }
            }
        }

        if (isPossible) {
            ret++;
        }
    }

    return ret;
}