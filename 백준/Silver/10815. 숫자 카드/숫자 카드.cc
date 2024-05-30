#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N;  cin >> N;
    vector<int> has_card(N);
    for(int i = 0 ; i < N ; i++)
        cin >> has_card[i];

    int M;  cin >> M;
    vector<int> search_card(M);
    for(int i = 0 ; i < M ; i++)
        cin >> search_card[i];

    vector<int> answer(M);

    sort(has_card.begin(), has_card.end());

    for(int i = 0 ; i < M ; i++){

        int card_num = search_card[i];

        int lo = 0;
        int hi = has_card.size() - 1;
        int ret = 1e9;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            int val = has_card[mid];

            if(card_num > val){
                // 높은 인덱스 탐색
                lo = mid + 1;
            }else if(card_num < val){
                hi = mid - 1;
            }else if(card_num == val){
                ret = mid;
                break;
            }
        }

        if(ret == 1e9)
            answer[i] = 0;
        else
            answer[i] = 1;

    }

    for(int i = 0 ; i < answer.size() ; i++){
        cout << answer[i];
        if(i != answer.size() - 1)
            cout << " ";
    }

}