#include <algorithm>
#include <iostream>
#include <tuple>
#include <vector>
#include <queue>

using namespace std;

int dy[4] = { 0,0,1,-1 };
int dx[4] = { 1,-1,0,0 };

// bfs로 탐색 후 블록 모양 반환
vector<tuple<int, int>> getBlock(vector<vector<int>>& table, vector<vector<bool>>& visit,
    int y, int x) {
    int len = table.size();
    vector<tuple<int, int>> block;
    queue<tuple<int, int>> q; // 큐 생성
    q.push({ y, x }); // 시작 위치 큐에 삽입
    visit[y][x] = true; // 방문 체크
    block.push_back({ 0,0 });

    while (!q.empty()) { // 큐가 빌 때까지 반복
        tuple<int, int> curr = q.front(); // 현재 위치
        int cur_y = get<0>(curr), cur_x = get<1>(curr); // 현재 y, x 좌표
        q.pop(); // 큐에서 제거

        for (int i = 0; i < 4; i++) { // 상하좌우 이동
            int ny = cur_y + dy[i], nx = cur_x + dx[i]; // 이동한 좌표
            if (ny < 0 || nx < 0 || ny >= len || nx >= len) continue; // 범위를 벗어난 경우
            if (visit[ny][nx] || table[ny][nx] == 0) continue; // 이미 방문했거나 블록이 없는 경우
            visit[ny][nx] = true; // 방문 체크
            block.push_back({ ny - y, nx - x }); // 블록에 추가
            q.push({ ny, nx }); // 큐에 추가
        }
    }

    return block;
}

// 모든 block들 반환
vector<vector<tuple<int, int>>> getBlocks(vector<vector<int>>& table) {
    vector<vector<tuple<int, int>>> blocks; // 블록들을 담을 벡터 생성
    int len = table.size();
    vector<vector<bool>> visit(len, vector<bool>(len)); // 방문 여부를 저장할 배열 생성

    for (int i = 0; i < len; i++) { // 테이블 순회
        for (int j = 0; j < len; j++) {
            if (table[i][j] == 0 || visit[i][j]) continue; // 블록이 없거나 이미 방문한 경우 건너뜀
            blocks.push_back(getBlock(table, visit, i, j)); // 블록 벡터에 추가
        }
    }

    return blocks; // 블록들 반환
}

// block을 시계방향으로 90도 돌림
vector<tuple<int, int>> rotateBlock(vector<tuple<int, int>>& block) {
    for (auto& piece : block) { // 블록 조각마다 반시계 방향으로 회전
        int temp = get<0>(piece);
        get<0>(piece) = get<1>(piece);
        get<1>(piece) = -temp;
    }
    return block; // 회전된 블록 반환
}




int countFill(vector<vector<int>>& game_board) {
    int ret = 0;
    for (const auto& row : game_board)
        for (const int& cell : row)
            if (cell == 1) ret++; // 채워진 영역 개수 카운트

    return ret; // 채워진 영역 개수 반환
}

bool canInsertBlock(vector<vector<int>>& game_board, vector<tuple<int, int>>& block,
    int y, int x) {
    int len = game_board.size(); // 게임 보드 길이
    for (const auto& piece : block) { // 블록 조각마다 체크
        int ny = y + get<0>(piece), nx = x + get<1>(piece); // 새로운 좌표
        if (ny < 0 || nx < 0 || ny >= len || nx >= len) return false; // 범위를 벗어난 경우
        if (game_board[ny][nx] != 0) return false; // 이미 채워져 있는 경우
    }
    return true; // 삽입 가능한 경우
}

bool checkAround(vector<vector<int>>& game_board, vector<tuple<int, int>>& block,
    int y, int x) {
    int len = game_board.size(); // 게임 보드 길이
    for (const auto& piece : block) { // 블록 조각마다 체크
        int ny = y + get<0>(piece), nx = x + get<1>(piece); // 새로운 좌표
        for (int i = 0; i < 4; i++) { // 주변 탐색
            int ay = ny + dy[i], ax = nx + dx[i]; // 주변 좌표
            if (ay < 0 || ax < 0 || ay >= len || ax >= len) continue; // 범위를 벗어난 경우
            if (game_board[ay][ax] == 0) return false; // 주변에 빈 공간이 있는 경우
        }
    }
    return true; // 주변에 빈 공간이 없는 경우
}

void insertBlock(vector<vector<int>>& game_board, vector<tuple<int, int>>& block,
    int y, int x) {
    for (const auto& piece : block) { // 블록 조각마다 삽입
        int ny = y + get<0>(piece), nx = x + get<1>(piece); // 새로운 좌표
        game_board[ny][nx] = 1; // 블록 삽입
    }
}

void removeBlock(vector<vector<int>>& game_board, vector<tuple<int, int>>& block,
    int y, int x) {
    for (const auto& piece : block) { // 블록 조각마다 제거
        int ny = y + get<0>(piece), nx = x + get<1>(piece); // 새로운 좌표
        game_board[ny][nx] = 0; // 블록 제거
    }
}

// 가능한 모든 블록을 넣고 최대 값 구하기
void doPuzzle(vector<vector<int>>& game_board,
    vector<vector<tuple<int, int>>>& blocks) {
    for (vector<tuple<int, int>> block : blocks) {
        bool flag = true;
        for (int r = 0; r < 4; r++) {
            if (!flag) break;
            if (r != 0) rotateBlock(block);

            for (int i = 0; i < game_board.size(); i++) {
                if (!flag) break;

                for (int j = 0; j < game_board.size(); j++) {
                    if (game_board[i][j] == 1) continue;
                    if (!canInsertBlock(game_board, block, i, j)) continue;

                    insertBlock(game_board, block, i, j);
                    if (!checkAround(game_board, block, i, j))
                        removeBlock(game_board, block, i, j);
                    else {
                        flag = false;
                        break;
                    }
                }
            }
        }
    }
}

int solution(vector<vector<int>> game_board, vector<vector<int>> table) {
    vector<vector<tuple<int, int>>> blocks = getBlocks(table);
    int initialFill = countFill(game_board);
    doPuzzle(game_board, blocks);

    return countFill(game_board) - initialFill;
}