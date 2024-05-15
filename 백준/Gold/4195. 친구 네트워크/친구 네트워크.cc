#include <algorithm>
#include <iostream>
#include <vector>
#include <map>

using namespace std;

int find_parent(int a, vector<int>& parent) {
    if(a != parent[a])
        parent[a] = find_parent(parent[a], parent);
    return parent[a];
}

void union_parent(int a, int b, vector<int>& parent, vector<int>& size) {
    int parent_a = find_parent(a, parent);
    int parent_b = find_parent(b, parent);

    if(parent_a != parent_b) {
        if(parent_a < parent_b) {
            parent[parent_b] = parent_a;
            size[parent_a] += size[parent_b];
        } else {
            parent[parent_a] = parent_b;
            size[parent_b] += size[parent_a];
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int test_case;  
    cin >> test_case;

    while (test_case > 0) {
        int e;  
        cin >> e; // 간선 개수
        int idx = 1; // 유저 인덱스 번호

        map<string, int> user;
        vector<int> parent(200000 + 10);
        vector<int> size(200000 + 10, 1); // 각 네트워크의 크기를 저장하는 배열

        for(int i = 1; i < parent.size(); i++)
            parent[i] = i;

        for(int i = 0; i < e; i++) {
            string user1, user2;    
            cin >> user1 >> user2;
            int user1_idx, user2_idx;

            // 이미 등록된 유저면 인덱스 값 반환 아니면 등록
            if(user.find(user1) != user.end()) {
                user1_idx = user[user1];
            } else {
                // 유저 등록
                user[user1] = idx;
                user1_idx = idx;
                idx++;
            }

            if(user.find(user2) != user.end()) {
                user2_idx = user[user2];
            } else {
                user[user2] = idx;
                user2_idx = idx;
                idx++;
            }

            // 두 개의 인덱스에 대해 union find로 루트 찾기
            union_parent(user1_idx, user2_idx, parent, size);

            // 네트워크 크기 출력
            int root = find_parent(user1_idx, parent);
            cout << size[root] << "\n";
        }
        test_case--;
    }
    return 0;
}