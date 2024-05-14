#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int get_root_node(int x, vector<int>& parent) {
    if(x != parent[x]){
        parent[x] = get_root_node(parent[x], parent);
    }
    return parent[x];
}

void union_parent(int a, int b, vector<int>& parent) {
    int root_a = get_root_node(a, parent);
    int root_b = get_root_node(b, parent);

    if(root_a < root_b) {
        parent[root_b] = root_a;
    }else{
        parent[root_a] = root_b;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n;  cin >> n;
    int m;  cin >> m;

    vector<int> parent(n + 1);
    for(int i = 1 ; i <= n ; i++)
        parent[i] = i;
    
    for(int i = 0 ; i < m ; i++) {
        int op, a, b;   cin >> op >> a >> b;

        if(op == 0) {
            union_parent(a, b, parent);
        }

        if(op == 1) {
            if(get_root_node(a, parent) == get_root_node(b, parent))
                cout << "YES\n";
            else
                cout << "NO\n";
        }
    }
}