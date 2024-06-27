#include <algorithm>
#include <iostream>
#include <vector>
#include <tuple>
#include <string>

using namespace std;

bool cmp(const tuple<string, int, int, int>& a, const tuple<string, int, int, int>& b) {
    if(get<1>(a) != get<1>(b))
        return get<1>(a) > get<1>(b);
    if(get<2>(a) != get<2>(b))
        return get<2>(a) < get<2>(b);
    if (get<3>(a) != get<3>(b))
        return get<3>(a) > get<3>(b);
    return get<0>(a) < get<0>(b);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N;
    cin >> N;

    vector<tuple<string, int, int, int>> students(N);
    for(auto& student : students) {
        cin >> get<0>(student) >> get<1>(student) >> get<2>(student) >> get<3>(student);
    }
    
    sort(students.begin(), students.end(), cmp);

    for(const auto& student : students) {
        cout << get<0>(student) << '\n';
    }

    return 0;
}