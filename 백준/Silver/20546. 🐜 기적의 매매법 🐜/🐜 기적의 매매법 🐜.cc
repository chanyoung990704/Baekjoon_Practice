#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int money;  cin >> money;

    vector<int> days(14);
    for(int i = 0 ; i < 14 ; i++)
        cin >> days[i];

    int j_money = money;
    int j_cnt = 0;
    for(int i = 0 ; i < 14 ; i++){
        if(j_money >= days[i]){
            j_cnt += j_money / days[i];
            j_money = j_money % days[i];
        }
    }

    j_money += (j_cnt * days[13]);

    int s_money = money;
    int s_cnt = 0;
    int up_cnt = 0;
    int downt_cnt = 0;
    for(int i = 1 ; i < 14 ; i++) {

        // 가격 하락
        if(days[i] < days[i - 1]){
            downt_cnt++;
            up_cnt = 0;

        }else if(days[i] > days[i - 1]){
            // 가격 상승
            up_cnt++;
            downt_cnt = 0;
        }else{
            up_cnt = 0;
            downt_cnt = 0;
        }

        if(downt_cnt >= 3 && s_money >= days[i]){
            s_cnt += s_money / days[i];            
            s_money = s_money % days[i];

        }

        if(up_cnt >= 3 && s_cnt > 0){
            s_money += (s_cnt * days[i]);
            s_cnt = 0;
        }

    }

    s_money += (s_cnt * days[13]);

    if(j_money == s_money)
        cout << "SAMESAME\n";
    else if(j_money > s_money)
        cout << "BNP\n";
    else
        cout << "TIMING\n";


}