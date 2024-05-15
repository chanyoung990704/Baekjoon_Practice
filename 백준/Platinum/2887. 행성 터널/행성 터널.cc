#include <algorithm>
#include <iostream>
#include <vector>
#include <tuple>

using namespace std;

int find_node(int x, vector<int>& parent) {
    if(x != parent[x])
        parent[x] = find_node(parent[x], parent);
    return parent[x];
}

void union_parent(int a, int b, vector<int>& parent) {
    int a_parent = find_node(a, parent);
    int b_parent = find_node(b, parent);

    if(a_parent < b_parent) {
        parent[b_parent] = a_parent;
    } else if(a_parent > b_parent) {
        parent[a_parent] = b_parent;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;  
    cin >> N;
    
    vector<tuple<int, int, int, int>> points(N); // (x, y, z, index)
    for(int i = 0; i < N; i++) {
        int x, y, z;
        cin >> x >> y >> z;
        points[i] = make_tuple(x, y, z, i + 1);
    }

    vector<pair<int, pair<int, int>>> edges; // (cost, (node1, node2))

    // 각 축별로 정렬하여 인접한 노드들 간의 간선 생성
    for(int dim = 0; dim < 3; dim++) {
        if(dim == 0) sort(points.begin(), points.end(), [](auto& a, auto& b) { return get<0>(a) < get<0>(b); });
        else if(dim == 1) sort(points.begin(), points.end(), [](auto& a, auto& b) { return get<1>(a) < get<1>(b); });
        else sort(points.begin(), points.end(), [](auto& a, auto& b) { return get<2>(a) < get<2>(b); });

        for(int i = 1; i < N; i++) {
            int cost = min({abs(get<0>(points[i]) - get<0>(points[i-1])), abs(get<1>(points[i]) - get<1>(points[i-1])), abs(get<2>(points[i]) - get<2>(points[i-1]))});
            edges.push_back({cost, {get<3>(points[i]), get<3>(points[i-1])}});
        }
    }

    // 정렬하고 parent 배열 초기화
    sort(edges.begin(), edges.end());
    vector<int> parent(N + 1);
    for(int i = 1; i <= N; i++)
        parent[i] = i;

    // 간선에 대해 크루스칼 진행
    long long total_cost = 0;
    for(auto edge : edges) {
        int cost = edge.first;
        int node1 = edge.second.first;
        int node2 = edge.second.second;

        if(find_node(node1, parent) != find_node(node2, parent)){
            total_cost += cost;
            union_parent(node1, node2, parent);
        }
    }

    cout << total_cost << "\n";

    return 0;
}