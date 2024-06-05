#include <vector>
using namespace std;

vector<int> solution(int n) {
    vector<vector<int>> triangle(n, vector<int>(n));
    vector<int> answer;
    int x = -1, y = 0, num = 1;
    
    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            if (i % 3 == 0) {
                x++;
            } else if (i % 3 == 1) {
                y++;
            } else {
                x--;
                y--;
            }
            triangle[x][y] = num++;
        }
    }
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j <= i; j++) {
            answer.push_back(triangle[i][j]);
        }
    }
    
    return answer;
}