#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    
    for(int i = 0 ; i < n ; i++) {
        
        int num = (arr1[i] | arr2[i]);
        
        // 2진수 만들기
        vector<int> binary_arr(n, 0);
        int idx = 0;
        
        while(num > 0) {
            binary_arr[idx++] = (num % 2);
            num /= 2;
        }
        
        reverse(binary_arr.begin(), binary_arr.end());
        
        string ans = "";
        
        for(int i = 0 ; i < n ; i++){
            if(binary_arr[i] == 1)
                ans.append("#");
            else
                ans.append(" ");
        }
        
        answer.push_back(ans);
    }
    
    return answer;
}