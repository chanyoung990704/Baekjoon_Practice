#include <iostream>
#include <map>
#include <string>
#include <iomanip>
using namespace std;

int main() {
    map<string, int> treeCounts;
    string treeName;
    int totalCount = 0;

    // 나무 종별로 개수 세기
    while (getline(cin, treeName)) {
        if (treeName == "") break; // 빈 줄이 나오면 입력 종료
        treeCounts[treeName]++;
        totalCount++;
    }

    // 비율 계산 및 출력
    cout << fixed << setprecision(4);
    for (const auto& pair : treeCounts) {
        double percentage = 100.0 * pair.second / totalCount;
        cout << pair.first << " " << percentage << "\n";
    }

    return 0;
}
