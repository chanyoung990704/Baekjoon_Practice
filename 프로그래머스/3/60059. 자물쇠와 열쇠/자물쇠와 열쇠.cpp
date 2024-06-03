#include <string>
#include <vector>

using namespace std;

vector<vector<int>> rotate_by_90(vector<vector<int>>& key) {
    int M = key.size();
    vector<vector<int>> rotate_key(M, vector<int>(M));
    
    for(int i = 0 ; i < M ; i++)
        for(int j = 0 ; j < M ; j++)
            rotate_key[j][M - i - 1] = key[i][j];
    
    return rotate_key;
}

vector<vector<int>> expand_lock(vector<vector<int>>& lock) {
    
    int M = lock.size();
    vector<vector<int>> expand_v(3 * M, vector<int>(3 * M, 0));
    
    for(int i = 0 ; i < M ; i++)
        for(int j = 0 ; j < M ; j++)
            expand_v[i + M][j + M] = lock[i][j];
    
    return expand_v;
    
}

bool isPossible(vector<vector<int>>& expand_v) {
    
    int M = expand_v.size() / 3;
    
    for(int i = 0 ; i < M ; i++)
        for(int j = 0 ; j < M ; j++)
            if(expand_v[M + i][M + j] != 1)
                return false;
    
    return true;
    
}

bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
    int N = lock.size();
    int M = key.size();
    vector<vector<int>> expand_v = expand_lock(lock);
    
    for(int i = 0 ; i < 4 ; i++) {
        key = rotate_by_90(key);
        
        for(int x = 0 ; x <= expand_v.size() - M ; x++) {
            for(int y = 0 ; y <= expand_v[0].size() - M ; y++) {
                
                for(int k_i = 0 ; k_i < M ; k_i++)
                    for(int k_j = 0; k_j < M; k_j++)
                        expand_v[x + k_i][y + k_j] += key[k_i][k_j];
                
                if(isPossible(expand_v))
                    return true;
                
                for(int k_i = 0 ; k_i < M ; k_i++)
                    for(int k_j = 0; k_j < M; k_j++)
                        expand_v[x + k_i][y + k_j] -= key[k_i][k_j];
            }
        }
    }
    
    return false;
}