#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int sort_idx = -1;

bool cmp(vector<int> a, vector<int> b) {
    return a[sort_idx] < b[sort_idx];
}

vector<vector<int>> solution(vector<vector<int>> data, string ext, int val_ext, string sort_by) {
    vector<vector<int>> answer;
    
    // ext와 sort_by에 해당하는 인덱스를 찾습니다.
    vector<string> op = {"code", "date", "maximum", "remain"};
    int ext_idx = find(op.begin(), op.end(), ext) - op.begin();
    sort_idx = find(op.begin(), op.end(), sort_by) - op.begin();
    
    // 조건을 만족하는 데이터를 필터링합니다.
    for (int i = 0; i < data.size(); i++) {
        if (data[i][ext_idx] < val_ext) {
            answer.push_back(data[i]);
        }
    }
    
    // 필터링된 데이터를 정렬합니다.
    sort(answer.begin(), answer.end(), cmp);
    
    return answer;
}