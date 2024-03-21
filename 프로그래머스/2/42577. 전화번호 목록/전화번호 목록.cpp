#include <iostream>
#include <vector>
#include <unordered_map>
#include <string>

using namespace std;

bool solution(vector<string> phone_book) {
    unordered_map<string, bool> prefix_map;

    // 전화번호부에 있는 모든 전화번호를 해시맵에 저장
    for (const string& number : phone_book) {
        prefix_map[number] = true;
    }

    // 각 전화번호를 순회하면서 접두어가 다른 전화번호에 있는지 확인
    for (const string& number : phone_book) {
        string prefix = "";
        // 각 전화번호의 접두어들을 추출하여 해시맵에서 찾음
        for (char c : number) {
            prefix += c;
            if (prefix_map.find(prefix) != prefix_map.end() && prefix != number) {
                return false; // 접두어가 다른 번호에 있는 경우
            }
        }
    }
    return true; // 모든 전화번호가 접두어가 아닌 경우
}