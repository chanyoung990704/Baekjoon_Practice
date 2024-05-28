#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    unordered_map<string, int> clothes_count;
    
    for (auto& item : clothes) {
        clothes_count[item[1]]++;
    }
    
    int answer = 1;
    
    for (auto& count : clothes_count) {
        answer *= (count.second + 1);
    }
    
    return answer - 1;
}