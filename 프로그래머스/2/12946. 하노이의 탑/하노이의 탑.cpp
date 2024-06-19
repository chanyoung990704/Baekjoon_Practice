#include <string>
#include <vector>

using namespace std;

void hanoi(int n, int start, int mid, int end, vector<vector<int>>& answer) {
    
    if(n == 1){
        answer.push_back(vector<int>{start, end});
        return;
    }
    
    hanoi(n - 1, start, end, mid, answer);
    answer.push_back(vector<int>{start, end});
    hanoi(n - 1, mid, start, end, answer);
    
}

vector<vector<int>> solution(int n) {
    vector<vector<int>> answer;
    hanoi(n, 1, 2, 3, answer);
    return answer;
}