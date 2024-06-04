#include <string>
#include <vector>
#include <algorithm>

using namespace std;

void brute_force(vector<vector<int>>& arr, vector<int>& answer, int size,
                int y, int x) {
    
    //basecase
    if(size == 1){
        if(arr[y][x] == 1)
            answer[1]++;
        else
            answer[0]++;
        return;
    }
    
    
    // 전체 탐색
    bool isPossible = true;
    int prev = arr[y][x];
    for(int i = 0 ; i < size ; i++){
        for(int j = 0 ; j < size ; j++)
            if(arr[y + i][x + j] != prev){
                isPossible = false;
                break;
            }
        if(!isPossible)
            break;
    }
                
    if(isPossible){
        answer[prev]++;
        return;
    }
    else{
        brute_force(arr, answer, size / 2, y, x);
        brute_force(arr, answer, size / 2, y, x + (size / 2));
        brute_force(arr, answer, size / 2, y + (size / 2), x);
        brute_force(arr, answer, size / 2, (y + size /2), (x + size / 2));
        return;
    }
    
    return;
}


vector<int> solution(vector<vector<int>> arr) {
    vector<int> answer = {0, 0};
    brute_force(arr, answer, arr.size(), 0, 0);
    return answer;
}