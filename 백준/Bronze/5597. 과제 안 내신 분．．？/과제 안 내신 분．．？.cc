#include <algorithm>
#include <iostream>
#include <vector>
#include <math.h>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    vector<int> students(31, 0);

    for(int i = 0 ; i < 28 ; i++){
        int n;  cin >> n;
        students[n]++;
    }

    auto iter1 = find(students.begin() + 1, students.end(), 0);
    auto iter2 = find(iter1 + 1, students.end(), 0);

    cout << iter1 - students.begin() << "\n";
    cout << iter2 - students.begin() << "\n";

}