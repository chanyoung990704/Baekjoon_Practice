#include <algorithm>
#include <iostream>
#include <vector>

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
    }else if(a_parent > b_parent) {
        parent[a_parent] = b_parent;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    while(true){
    
        int N;  cin >> N;
        int M;  cin >> M;

        // N 과 M이 0이면 종료
        if(N == 0 && M == 0)
            break;

        // 크루스칼 알고리즘 후 전체 간선 비용 - 크루스칼 비용

        // parent 초기화
        vector<int> parent(N + 1);
        for(int i = 1 ; i <= N ; i++)
            parent[i] = i;

        // 간선 담을 배열 초기화 & 오름차순 정렬 & 전체 간선 비용 저장
        long long total_adj_cost = 0;
        vector<pair<long long, pair<int, int>>> adj(M); // <비용, <노드1, 노드2>>
        for(int i = 0 ; i < M ; i++) {
            cin >> adj[i].second.first >> adj[i].second.second >> adj[i].first;
            total_adj_cost += adj[i].first;
        }
        sort(adj.begin(), adj.end(), less<pair<long long, pair<int, int>>>());

        // 정렬된 간선 순회하고 사이클 아니면 유니온하고 간선 비용 저장
        long long total_cost = 0;
        for(auto cur : adj) {
            long long cost = cur.first;
            int node1 = cur.second.first;
            int node2 = cur.second.second;

            // 사이클 아닌 경우 유니온
            if(find_node(node1, parent) != find_node(node2, parent)) {
                union_parent(node1, node2, parent);
                total_cost += cost;
            }

        }

        // 절약한 비용 
        cout << total_adj_cost - total_cost << "\n";

    }

    return 0;
}