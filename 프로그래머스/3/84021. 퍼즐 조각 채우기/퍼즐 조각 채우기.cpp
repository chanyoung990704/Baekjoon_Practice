#include <algorithm> // 알고리즘 라이브러리
#include <queue> // 큐 라이브러리
#include <string> // 문자열 라이브러리
#include <vector> // 벡터 라이브러리

using namespace std; // 표준 네임스페이스 사용

int dy[] = { -1, 0, 1, 0 }, dx[] = { 0, 1, 0, -1 }; // y, x 방향 이동 배열
int len; // 게임 보드 길이 저장

// bfs로 탐색 후 블록 모양 반환
vector<vector<int>> getBlock(vector<vector<int>>& table, vector<vector<bool>>& visit,
    int y, int x) {
    vector<vector<int>> block;
    queue<vector<int>> q; // 큐 생성
    q.push({ y, x }); // 시작 위치 큐에 삽입
    visit[y][x] = true; // 방문 체크
    block.push_back({ 0,0 });

    while (!q.empty()) { // 큐가 빌 때까지 반복
        vector<int> curr = q.front(); // 현재 위치
        int cur_y = curr[0], cur_x = curr[1]; // 현재 y, x 좌표
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
vector<vector<vector<int>>> getBlocks(vector<vector<int>>& table) {
    vector<vector<vector<int>>> blocks; // 블록들을 담을 벡터 생성
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
vector<vector<int>> rotateBlock(vector<vector<int>>& block) {
    for (auto& piece : block) { // 블록 조각마다 반시계 방향으로 회전
        int temp = piece[0];
        piece[0] = piece[1];
        piece[1] = -temp;
    }
    return block; // 회전된 블록 반환
}

// 보드가 채워진 개수 반환
int countFill(vector<vector<int>>& game_board) {
    int ret = 0;
    for (int i = 0; i < len; i++)
        for (int j = 0; j < len; j++)
            if (game_board[i][j] == 1) ret++; // 채워진 영역 개수 카운트

    return ret; // 채워진 영역 개수 반환
}

// block이 들어갈 y,x 좌표가 비어있는지 체크
bool canInsertBlock(vector<vector<int>>& game_board, vector<vector<int>>& block,
    int y, int x) {
    for (const auto& piece : block) { // 블록 조각마다 체크
        int ny = y + piece[0], nx = x + piece[1]; // 새로운 좌표
        if (ny < 0 || nx < 0 || ny >= len || nx >= len) return false; // 범위를 벗어난 경우
        if (game_board[ny][nx] != 0) return false; // 이미 채워져 있는 경우
    }
    return true; // 삽입 가능한 경우
}

// block을 넣은 후 주변에 빈공간 있는지 체크
bool checkAround(vector<vector<int>>& game_board, vector<vector<int>>& block,
    int y, int x) {
    for (const auto& piece : block) { // 블록 조각마다 체크
        int ny = y + piece[0], nx = x + piece[1]; // 새로운 좌표
        for (int i = 0; i < 4; i++) { // 주변 탐색
            int ay = ny + dy[i], ax = nx + dx[i]; // 주변 좌표
            if (ay < 0 || ax < 0 || ay >= len || ax >= len) continue; // 범위를 벗어난 경우
            if (game_board[ay][ax] == 0) return false; // 주변에 빈 공간이 있는 경우
        }
    }
    return true; // 주변에 빈 공간이 없는 경우
}

// 보드에 블록 넣기
void insertBlock(vector<vector<int>>& game_board, vector<vector<int>>& block,
    int y, int x) {
    for (const auto& piece : block) { // 블록 조각마다 삽입
        int ny = y + piece[0], nx = x + piece[1]; // 새로운 좌표
        game_board[ny][nx] = 1; // 블록 삽입
    }
}

// 보드에서 블록 제거
void removeBlock(vector<vector<int>>& game_board, vector<vector<int>>& block,
    int y, int x) {
    for (const auto& piece : block) { // 블록 조각마다 제거
        int ny = y + piece[0], nx = x + piece[1]; // 새로운 좌표
        game_board[ny][nx] = 0; // 블록 제거
    }
}

// 가능한 모든 블록을 넣고 최대 값 구하기
void doPuzzle(vector<vector<int>>& game_board,
    vector<vector<vector<int>>>& blocks) {
    for (auto& block : blocks) { // 모든 블록에 대해 반복
        bool flag = true;
        for (int r = 0; r < 4; r++) { // 90도씩 회전하며 모든 위치에 대해 시도
            if (!flag) break;
            if (r != 0) rotateBlock(block); // 회전

            for (int i = 0; i < len; i++) { // 보드 모든 위치에 대해 검사
                if (!flag) break;

                for (int j = 0; j < len; j++) {
                    if (game_board[i][j] == 1) continue; // 이미 채워진 곳은 건너뜀
                    if (!canInsertBlock(game_board, block, i, j)) continue; // 삽입 불가능한 경우

                    insertBlock(game_board, block, i, j); // 블록 삽입
                    if (!checkAround(game_board, block, i, j)) // 주변에 빈 공간이 있는지 확인
                        removeBlock(game_board, block, i, j); // 없다면 블록 제거
                    else {
                        flag = false; // 블록 삽입 성공
                        break;
                    }
                }
            }
        }
    }
}

// 메인 함수: 게임 보드와 테이블을 이용해 채울 수 있는 최대 영역 구하기
int solution(vector<vector<int>> game_board, vector<vector<int>> table) {
    len = game_board.size(); // 보드 길이 저장
    vector<vector<vector<int>>> blocks = getBlocks(table); // 테이블로부터 블록들 추출
    int initialFill = countFill(game_board); // 초기 채워진 곳 개수 계산
    doPuzzle(game_board, blocks); // 블록 삽입하여 최대 영역 채우기

    return countFill(game_board) - initialFill; // 최대 영역 개수 반환
}
