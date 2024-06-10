#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int N;
vector<int> recommend_idx;

bool cmp(pair<int, int> a, pair<int, int> b) {
    if(recommend_idx[a.first] != recommend_idx[b.first])
        return recommend_idx[a.first] < recommend_idx[b.first];
    else
        return a.second < b.second;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    recommend_idx.resize(101, 0); // 학생 번호는 1부터 100까지로 가정
    vector<pair<int, int>> photo_case;

    int M;  cin >> M;
    for(int i = 0 ; i < M ; i++) {
        int idx;    cin >> idx;

        // 사진이 걸려있는 경우
        if(recommend_idx[idx] != 0){
            recommend_idx[idx]++;
            continue;
        }

        // 초기화
        if(photo_case.size() < N){
            recommend_idx[idx]++;
            photo_case.push_back(make_pair(idx, i));
            continue;
        }


        // 삭제해야 하는 경우

        // 정렬
        sort(photo_case.begin(), photo_case.end(), cmp);
        // 추천수 0으로
        recommend_idx[photo_case[0].first] = 0;
        // 삭제
        photo_case.erase(photo_case.begin());
        // 삽입
        recommend_idx[idx]++;
        photo_case.push_back(make_pair(idx, i));
    }

    for(int i = 1; i <= 100 ; i++)
        if(recommend_idx[i] != 0)
            cout << i << " ";
}