#include <algorithm>
#include <iostream>
#include <math.h>
#include <vector>

using namespace std;

int get_chicken_distance(pair<int, int> p1, pair<int, int> p2){
    return abs(p1.first - p2.first) + abs(p1.second - p2.second);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;  cin >> N;
    int M;  cin >> M;

    vector<pair<int, int>> house_idx;
    vector<pair<int, int>> chicken_idx;

    for(int i = 1 ; i <= N ; i++)
        for(int j = 1 ; j <= N ; j++){
            int n;  cin >> n;
            if(n == 1)
                house_idx.push_back(make_pair(i, j));
            else if(n == 2)
                chicken_idx.push_back(make_pair(i, j));
        }


    int result = 1e9;

    vector<bool> v(chicken_idx.size());
    fill(v.begin(), v.begin() + M, true);

    do{
        vector<int> distance(house_idx.size(), 1e9);

        for(int i = 0 ; i < v.size() ; i++){
            if(v[i]){
                for(int j = 0 ; j < house_idx.size(); j++){
                    int dist = get_chicken_distance(chicken_idx[i], house_idx[j]);
                    distance[j] = min(distance[j], dist);
                }
            }
        }

        int total = 0;
        for(auto& dis : distance)
            total += dis;

        result = min(result, total);

    }while(prev_permutation(v.begin(), v.end()));

    cout << result;
}