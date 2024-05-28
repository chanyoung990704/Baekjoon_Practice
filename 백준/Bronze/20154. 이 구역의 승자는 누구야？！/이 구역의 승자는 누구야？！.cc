#include <iostream>
#include <vector>
using namespace std;

int main() {
    string input;
    cin >> input;
    
    // 알파벳 대문자의 획수 매핑
    int strokes[26] = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};
    vector<int> numbers;
    
    // 입력 문자열을 획수로 변환
    for(char ch : input) {
        numbers.push_back(strokes[ch - 'A']);
    }
    
    // 획수 더하기
    while(numbers.size() > 1) {
        vector<int> temp;
        for(int i = 0; i < numbers.size(); i += 2) {
            if(i + 1 < numbers.size()) {
                temp.push_back((numbers[i] + numbers[i+1]) % 10);
            } else {
                temp.push_back(numbers[i]);
            }
        }
        numbers = temp;
    }
    
    // 승자 결정
    if(numbers[0] % 2 == 1) {
        cout << "I'm a winner!";
    } else {
        cout << "You're the winner?";
    }
    
    return 0;
}