#include <string>
#include <vector>
#include <algorithm>

using namespace std;
    
// 이동해야 하는 좌표 획득

int get_val(vector<int>& q, vector<vector<int>>& arr) {
    vector<int> result;
    
    int x1 = q[0];  int y1 = q[1];  int x2 = q[2];  int y2 = q[3];
    
    // x1 y1 ~ x1 y2
    for(int i = y1 ; i <= y2 ; i++)
        result.push_back(arr[x1][i]);
    
    // x1 y2 ~ x2 y2
    for(int i = x1 + 1 ; i <= x2 ; i++)
        result.push_back(arr[i][y2]);
    
    //x2 y2 ~ x2 y1
    for(int i = y2 - 1 ; i >= y1 ; i--)
        result.push_back(arr[x2][i]);
    
    // x2 y1 ~ x1 y1
    for(int i = x2 -1 ; i >= x1 ; i--)
        result.push_back(arr[i][y1]);
    
    result.insert(result.begin(), result.back());
    result.pop_back();
    int min_val = *min_element(result.begin(), result.end());
    
    // 시계 방향 갱신
    int idx = 0;
    // x1 y1 ~ x1 y2
    for(int i = y1 ; i <= y2 ; i++){
        arr[x1][i] = result[idx];
        idx++;
    }
    
    // x1 y2 ~ x2 y2
    for(int i = x1 + 1 ; i <= x2 ; i++){
        arr[i][y2] = result[idx];
        idx++;
    }
    
    //x2 y2 ~ x2 y1
    for(int i = y2 - 1 ; i >= y1 ; i--){
        arr[x2][i] = result[idx];
        idx++;
    }
    
    // x2 y1 ~ x1 y1
    for(int i = x2 -1 ; i >= x1 ; i--){
        arr[i][y1] = result[idx];
        idx++;
    }
    
    return min_val;
        
}



vector<int> solution(int rows, int columns, vector<vector<int>> queries) {
    vector<int> answer;
    // arr 생성
    vector<vector<int>> arr(rows + 1, vector<int>(columns + 1));
    
    int val = 1;
    for(int i = 1 ; i <= rows ; i++)
        for(int j = 1 ; j <= columns ; j++)
            arr[i][j] = val++;
    
    
    for(auto& query : queries) {
        answer.push_back(get_val(query, arr));
    }
    
    return answer;
}