#include <string>
#include <vector>

using namespace std;

void hanoi(int n, int start, int mid, int end,
          vector<vector<int>>& answer) {
    
    // 1개일 때 start -> end
    if(n == 1){
        answer.push_back(vector<int>{start, end});
        return;
    }
    
    // n -1 개를 mid로
    hanoi(n - 1, start, end, mid, answer);
    
    // 1개 남은 것을 end로
    answer.push_back(vector<int>{start, end});
    
    // mid로 옮긴 n -1 개를 다시 end로
    hanoi(n - 1, mid, start, end, answer);
    
    
}

vector<vector<int>> solution(int n) {
    vector<vector<int>> answer;
    hanoi(n, 1, 2, 3, answer);
    return answer;
}