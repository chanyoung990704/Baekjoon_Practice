#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T; // 테스트 케이스의 개수를 입력받습니다.

    while (T--) {
        string message;
        cin >> message; // 각 테스트 케이스의 메시지를 입력받습니다.
        vector<int> cnt(26, 0); // 알파벳의 출현 횟수를 저장할 벡터를 초기화합니다.

        bool isFake = false; // 메시지가 가짜인지를 표시하는 플래그입니다.

        for (int i = 0; i < message.size(); i++) {
            int index = message[i] - 'A'; // 현재 문자의 알파벳 인덱스를 계산합니다.
            cnt[index]++; // 해당 문자의 출현 횟수를 증가시킵니다.

            if (cnt[index] % 3 == 0) { // 문자가 세 번째 등장했다면
                // 다음 문자가 같은지 확인합니다. i+1이 문자열의 끝을 넘지 않게 주의합니다.
                if (i + 1 >= message.size() || message[i] != message[i + 1]) {
                    isFake = true; // 다음 문자가 없거나 다른 문자라면 메시지는 가짜입니다.
                    break;
                } else {
                    i++; // 다음 문자가 같다면, 그 문자는 삽입된 문자로 간주하고 건너뜁니다.
                }
            }
        }

        if (isFake) {
            cout << "FAKE" << "\n";
        } else {
            cout << "OK" << "\n";
        }
    }

    return 0;
}
