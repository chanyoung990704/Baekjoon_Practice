#include <algorithm>
#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<int> in_people(10, 0);
    vector<int> out_people(10, 0);

    for(int i = 0 ; i < 10 ; i++){
        cin >> out_people[i] >> in_people[i];

        if(i != 0) {
            in_people[i] += in_people[i - 1];
            out_people[i] += out_people[i - 1];
        }
    }

    int max_people = 0;
    for(int i = 0 ; i < 10 ; i++){
        max_people = max(max_people, in_people[i] - out_people[i]);
    }

    cout << max_people << "\n";

}