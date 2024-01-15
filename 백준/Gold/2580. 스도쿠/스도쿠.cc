#include <iostream>
#include <vector>

using namespace std;

bool solveSudoku(vector<vector<int>>& board, int row, int col) {
    const int SIZE = 9; // 스도쿠의 크기
    // 스도쿠 판이 완성되었는지 확인
    if (row == SIZE) {
        for (const auto& r : board) {
            for (const auto& num : r) {
                cout << num << ' ';
            }
            cout << '\n';
        }
        return true; // 스도쿠 완성 후 출력하고 종료
    }

    // 다음 행으로 이동
    if (col == SIZE) return solveSudoku(board, row + 1, 0);

    // 이미 채워진 칸은 건너뛰기
    if (board[row][col] != 0) return solveSudoku(board, row, col + 1);

    // 빈 칸에 1부터 9까지의 숫자 시도
    for (int num = 1; num <= SIZE; ++num) {
        bool canPlace = true;
        for (int i = 0; i < SIZE; ++i) {
            if (board[row][i] == num || board[i][col] == num) {
                canPlace = false; // 같은 행이나 열에 동일한 숫자가 있으면 안됨
                break;
            }
        }
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[row / 3 * 3 + i][col / 3 * 3 + j] == num) {
                    canPlace = false; // 3x3 서브그리드 내에 동일한 숫자가 있으면 안됨
                    break;
                }
            }
            if (!canPlace) break;
        }

        if (canPlace) {
            board[row][col] = num; // 숫자를 놓고
            if (solveSudoku(board, row, col + 1)) return true;
            board[row][col] = 0; // 실패했다면 다시 0으로 되돌림 (백트래킹)
        }
    }

    return false; // 해당 위치에 어떤 숫자도 놓을 수 없다면 false 반환
}

int main() {
    vector<vector<int>> board(9, vector<int>(9));
    for (int i = 0; i < 9; ++i) {
        for (int j = 0; j < 9; ++j) {
            cin >> board[i][j]; // 스도쿠 판 입력 받기
        }
    }

    if (!solveSudoku(board, 0, 0)) {
        cout << "No solution exists."; // 스도쿠를 풀 수 없는 경우
    }

    return 0;
}
