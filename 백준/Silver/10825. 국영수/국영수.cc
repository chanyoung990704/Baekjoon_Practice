#include <algorithm>
#include <iostream>
#include <vector>
#include <tuple>

using namespace std;

bool cmp(tuple<string, int, int, int>& a, tuple<string, int, int, int>& b) {
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
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N;  cin >> N;

    vector<tuple<string, int, int, int>> students(N);
    for(int i = 0 ; i < N ; i++)
        cin >> get<0>(students[i]) >> get<1>(students[i]) >>
        get<2>(students[i]) >> get<3>(students[i]);
    
    sort(students.begin(), students.end(), cmp);

    for(auto& s : students)
        cout << get<0>(s) << "\n";

    

}