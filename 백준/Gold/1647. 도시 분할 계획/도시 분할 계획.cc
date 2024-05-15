#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int find_node(int x, vector<int>& parent) {
    if(x != parent[x])
        parent[x] = find_node(parent[x], parent);
    return parent[x];
}

int union_parent(int a, int b, vector<int>& parent) {
    int a_parent = find_node(a, parent);
    int b_parent = find_node(b, parent);

    if(a_parent < b_parent) {
        parent[b_parent] = a_parent;
    } else if(a_parent > b_parent) {
        parent[a_parent] = b_parent;
    }
    return 0; // 반환값 추가
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N;  cin >> N;
    int M;  cin >> M;

    // 크루스칼 알고리즘 쓰고 최대 경로 제거

    // parent 초기화
    vector<int> parent(N + 1);
    for(int i = 1 ; i <= N ; i++)
        parent[i] = i;

    // 간선 담을 배열 초기화 & 오름차순 정렬
    vector<pair<int, pair<int, int>>> adj(M); // <비용, <노드1, 노드2>>
    for(int i = 0 ; i < M ; i++) {
        cin >> adj[i].second.first >> adj[i].second.second >> adj[i].first;
    }
    sort(adj.begin(), adj.end(), less<pair<int, pair<int, int>>>());

    // 정렬된 간선 순회하고 사이클 아니면 유니온 그리고 간선 값 배열에 저장
    vector<int> cost_arr;
    int total_cost = 0;
    for(auto cur : adj) {
        int cost = cur.first;
        int node1 = cur.second.first;
        int node2 = cur.second.second;

        // 사이클 아닌 경우 유니온
        if(find_node(node1, parent) != find_node(node2, parent)) {
            union_parent(node1, node2, parent);
            cost_arr.push_back(cost);
            total_cost += cost;
        }
    }

    // 최댓값 제거
    if (!cost_arr.empty()) { // 벡터가 비어있지 않은지 확인
        int max_cost = *max_element(cost_arr.begin(), cost_arr.end());
        total_cost -= max_cost;
    }

    cout << total_cost << "\n";
}