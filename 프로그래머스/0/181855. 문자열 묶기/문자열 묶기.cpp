#include <string>
#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<string> strArr) {
    int answer = 0;
    vector<int> size_arr(31, 0);
    for(int i = 0 ; i < strArr.size() ; i++)
        size_arr[strArr[i].size()]++;
    
    answer = *max_element(size_arr.begin(), size_arr.end());
    return answer;
}