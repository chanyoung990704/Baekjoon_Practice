#include <algorithm>
#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;  cin >> N;
    vector<int> switch_stat(N + 1);

    for(int i = 1 ; i <= N; i++)
        cin >> switch_stat[i];

    int T;  cin >> T;

    for(int i = 0 ; i < T ; i++) {

        int op, idx;
        cin >> op >> idx;

        if(op == 1){
            // 남자
            for(int j = idx ; j <= N ; j++){
                if(j % idx == 0)
                    switch_stat[j] = (switch_stat[j] == 0) ? 1 : 0;
            }

        }else if(op == 2){
            // 여자
            int l_idx = idx;
            int r_idx = idx;

            int tmp_l = idx;
            int tmp_r = idx;

            while(tmp_l >= 1 && tmp_r <= N){

                // 대칭이라면
                if(switch_stat[tmp_l] == switch_stat[tmp_r]){
                    l_idx = tmp_l--;
                    r_idx = tmp_r++;
                }else{
                    break;
                }
            }

            for(int j = l_idx ; j <= r_idx ; j++)
                switch_stat[j] = (switch_stat[j] == 0) ? 1 : 0;

        }
    }


    for(int i = 1 ; i <= N ; i++){
        cout << switch_stat[i];
        if(i % 20 == 0){
            cout << "\n";
            continue;
        }
        if(i != N)
            cout << " ";
    }
    
}