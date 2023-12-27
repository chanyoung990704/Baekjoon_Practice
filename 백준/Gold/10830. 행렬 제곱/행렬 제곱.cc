#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>

using namespace std;
const int MOD = 1000;

vector<vector<int>> matrix;

vector<vector<int>> getMulMatrix(const vector<vector<int>>& matrix1, const vector<vector<int>>& matrix2, const int& size) {
    vector<vector<int>> result = vector<vector<int>>(size, vector<int>(size));

    for(int i = 0 ; i < size ; i++) // 행
        for(int j = 0 ; j < size ; j++) //열
            for(int k = 0 ; k < size ; k++) {
                result[i][j] +=
                    matrix1[i][k] * matrix2[k][j];
                result[i][j] %= MOD;
            }

    return result;
}

vector<vector<int>> getPowMatrix(vector<vector<int>>& matrix, const int& size, long long& exp) {
    vector<vector<int>> result = vector<vector<int>>(size, vector<int>(size));

    for (int i = 0; i < size; i++)
        result[i][i] = 1;

    while (exp > 0) {
        if (exp % 2 == 1) {
            result = getMulMatrix(result, matrix, size);
        }
        matrix = getMulMatrix(matrix, matrix, size);
        exp /= 2;
    }

    return result;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N; cin >> N;
    long long B;    cin >> B;
    matrix = vector<vector<int>>(N, vector<int>(N));

    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            cin >> matrix[i][j];


    vector<vector<int>> result = getPowMatrix(matrix, N, B);

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
            cout << result[i][j] << " ";
        cout << "\n";
    }
}
