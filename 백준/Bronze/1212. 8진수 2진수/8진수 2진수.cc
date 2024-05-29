#include <algorithm>
#include <iostream>
#include <vector>
#include <iomanip>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    string num; cin >> num;

    string result = "";

    for(int i = 0; i < num.size(); i++){
        string tmp = "000";
        char cur = num[i];
        int n = cur - '0';

        int idx = 2;
        while(n > 0){
            int tmp_n = n % 2;
            tmp[idx--] = tmp_n + '0';
            n /= 2;
        }

        if (i == 0) {
            // 첫 번째 숫자의 경우 앞의 '0'을 제거
            size_t pos = tmp.find('1');
            if (pos != string::npos) {
                result += tmp.substr(pos);
            } else {
                result += "0"; // 모든 자리가 '0'인 경우
            }
        } else {
            result += tmp;
        }
    }

    cout << result << "\n";
    return 0;
}