import java.io.*;
import java.util.*;

public class Main {

    static int max = 0;

    static class Block {
        int val;
        boolean b;

        Block(int val, boolean b) {
            this.val = val;
            this.b = b;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        Block[][] arr = new Block[N][N];
        for (int i = 0; i < N; i++) {
            // 초기 입력 부분은 Stream 대신 StringTokenizer를 사용하는 것이 일반적으로 더 빠릅니다. (선택사항)
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = new Block(Integer.parseInt(st.nextToken()), false);
            }
        }

        Stack<Block[][]> stack = new Stack<>();
        solve(arr, stack, 0);
        System.out.println(max);
    }

    private static void solve(Block[][] arr, Stack<Block[][]> stack, int i) {
        if (i == 5) {
            max = Math.max(max, getMax(arr));
            return;
        }

        for (int j = 0; j < 4; j++) {
            // 현재 상태를 깊은 복사하여 스택에 저장
            Block[][] copiedArr = copyArr(arr);
            stack.push(copiedArr);

            // 시뮬레이션은 원본 배열을 직접 수정
            moveArr(arr, j);
            solve(arr, stack, i + 1);

            // 백트래킹: 스택에서 이전 상태를 복원
            arr = stack.pop();
        }
    }

    private static void moveArr(Block[][] arr, int j) {
        // [수정 1] : 매 이동 시뮬레이션 시작 전, 모든 블록의 'merged' 상태(b)를 false로 초기화
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                arr[row][col].b = false;
            }
        }

        switch (j) {
            case 0: moveUp(arr); break;
            case 1: moveDown(arr); break;
            case 2: moveLeft(arr); break;
            case 3: moveRight(arr); break;
        }
    }

    // [수정 2] : 모든 move 메서드의 합치기(merge) 조건 수정
    private static void moveRight(Block[][] arr) {
        // 오른쪽으로 이동하므로, 오른쪽 열부터 탐색 (루프 순서는 올바름)
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[0].length - 2; j >= 0; j--) {
                if (arr[i][j].val > 0) {
                    int x = j;
                    // 오른쪽으로 빈 칸 만큼 이동
                    while (x < arr[0].length - 1 && arr[i][x + 1].val == 0) {
                        x++;
                    }
                    // 합칠 수 있는지 확인
                    if (x < arr[0].length - 1 && !arr[i][x + 1].b && arr[i][x + 1].val == arr[i][j].val) {
                        arr[i][x + 1].val += arr[i][j].val;
                        arr[i][x + 1].b = true;
                        arr[i][j].val = 0;
                    } else { // 합치지 못하고 이동만 하는 경우
                        int tempVal = arr[i][j].val;
                        arr[i][j].val = 0;
                        arr[i][x].val = tempVal;
                    }
                }
            }
        }
    }

    private static void moveLeft(Block[][] arr) {
        // 왼쪽으로 이동하므로, 왼쪽 열부터 탐색 (루프 순서는 올바름)
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][j].val > 0) {
                    int x = j;
                    while (x > 0 && arr[i][x - 1].val == 0) {
                        x--;
                    }
                    // 합칠 수 있는지 확인: 이동하려는 블록(arr[i][j])과 합쳐질 대상(arr[i][x-1]) 비교
                    if (x > 0 && !arr[i][x - 1].b && arr[i][x - 1].val == arr[i][j].val) {
                        arr[i][x - 1].val += arr[i][j].val;
                        arr[i][x - 1].b = true;
                        arr[i][j].val = 0;
                    } else {
                        int tempVal = arr[i][j].val;
                        arr[i][j].val = 0;
                        arr[i][x].val = tempVal;
                    }
                }
            }
        }
    }

    private static void moveDown(Block[][] arr) {
        // 아래로 이동하므로, 아래 행부터 탐색 (루프 순서는 올바름)
        for (int j = 0; j < arr[0].length; j++) {
            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i][j].val > 0) {
                    int y = i;
                    while (y < arr.length - 1 && arr[y + 1][j].val == 0) {
                        y++;
                    }
                    if (y < arr.length - 1 && !arr[y + 1][j].b && arr[y + 1][j].val == arr[i][j].val) {
                        arr[y + 1][j].val += arr[i][j].val;
                        arr[y + 1][j].b = true;
                        arr[i][j].val = 0;
                    } else {
                        int tempVal = arr[i][j].val;
                        arr[i][j].val = 0;
                        arr[y][j].val = tempVal;
                    }
                }
            }
        }
    }

    private static void moveUp(Block[][] arr) {
        // 위로 이동하므로, 위 행부터 탐색 (루프 순서는 올바름)
        for (int j = 0; j < arr[0].length; j++) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i][j].val > 0) {
                    int y = i;
                    while (y > 0 && arr[y - 1][j].val == 0) {
                        y--;
                    }
                    if (y > 0 && !arr[y - 1][j].b && arr[y - 1][j].val == arr[i][j].val) {
                        arr[y - 1][j].val += arr[i][j].val;
                        arr[y - 1][j].b = true;
                        arr[i][j].val = 0;
                    } else {
                        int tempVal = arr[i][j].val;
                        arr[i][j].val = 0;
                        arr[y][j].val = tempVal;
                    }
                }
            }
        }
    }

    // `copyArr`는 이제 `b` 플래그를 복사할 필요가 없어졌습니다. (매번 초기화 하므로)
    // 하지만 기존 구조 유지를 위해 그대로 두겠습니다.
    static Block[][] copyArr(Block[][] arr) {
        Block[][] newArr = new Block[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                // b 상태까지 그대로 복사 (백트래킹을 위함)
                newArr[i][j] = new Block(arr[i][j].val, arr[i][j].b);
            }
        }
        return newArr;
    }

    static int getMax(Block[][] arr) {
        int currentMax = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                currentMax = Math.max(currentMax, arr[i][j].val);
            }
        }
        return currentMax;
    }
}
