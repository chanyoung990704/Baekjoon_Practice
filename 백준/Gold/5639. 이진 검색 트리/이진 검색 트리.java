import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    // 전위 순회 결과를 저장할 리스트 (전역 변수로 선언하여 재귀 함수에서 쉽게 접근)
    static ArrayList<Integer> preorder = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 입력을 효율적으로 받기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        // 입력의 끝(null)까지 한 줄씩 읽어서 정수로 변환 후 리스트에 추가
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            preorder.add(Integer.parseInt(line));
        }

        // 전체 트리를 대상으로 후위 순회 시작 (인덱스 0부터 마지막 인덱스까지)
        postOrder(0, preorder.size() - 1);
    }

    /**
     * 후위 순회를 출력하는 재귀 함수
     * @param start 현재 서브트리의 시작 인덱스
     * @param end   현재 서브트리의 끝 인덱스
     */
    public static void postOrder(int start, int end) {
        // 기저 조건: 시작 인덱스가 끝 인덱스를 넘어서면 서브트리가 없는 것이므로 리턴
        if (start > end) {
            return;
        }

        // 1. 루트 노드는 현재 서브트리의 첫 번째 요소
        int root = preorder.get(start);

        // 2. 오른쪽 서브트리의 시작점을 찾는다.
        // start + 1 부터 탐색하여 root보다 큰 값이 처음 나오는 위치를 찾는다.
        int rightSubtreeStartIndex = end + 1; // 오른쪽 서브트리가 없는 경우를 대비한 초기값
        for (int i = start + 1; i <= end; i++) {
            if (preorder.get(i) > root) {
                rightSubtreeStartIndex = i;
                break;
            }
        }

        // 3. 왼쪽 서브트리에 대해 재귀 호출 (Left)
        // 범위: start + 1 부터 rightSubtreeStartIndex - 1 까지
        postOrder(start + 1, rightSubtreeStartIndex - 1);

        // 4. 오른쪽 서브트리에 대해 재귀 호출 (Right)
        // 범위: rightSubtreeStartIndex 부터 end 까지
        postOrder(rightSubtreeStartIndex, end);

        // 5. 루트 노드 값 출력 (Root)
        System.out.println(root);
    }
}
