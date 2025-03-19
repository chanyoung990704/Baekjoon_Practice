
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static class Node {
        boolean isEnd = false;
        Node[] children = new Node[26]; // 알파벳 소문자만 처리한다고 가정
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 개수 NM
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        // 트라이 위한 루트
        Node root = new Node();

        // N개동안 저장될 문자
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            insertTrie(root, line);
        }

        int cnt = 0;
        // M개동안 찾을 문자
        for (int i = 0; i < M; i++) {
            String line = br.readLine();

            if (isFinded(root, line)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static boolean isFinded(Node cur, String line) {
        // 단계 단계 내려가기
        for (char c : line.toCharArray()) {
            int index = c - 'a'; // 알파벳 소문자를 인덱스로 변환
            
            // 해당 문자에 대한 노드가 없으면 false 반환
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }

        // 최종 도착한 것이 트루여야 함
        return cur.isEnd;
    }

    private static void insertTrie(Node cur, String line) {
        for (char c : line.toCharArray()) {
            int index = c - 'a'; // 알파벳 소문자를 인덱스로 변환
            
            // 해당 문자에 대한 노드가 없으면 생성
            if (cur.children[index] == null) {
                cur.children[index] = new Node();
            }
            cur = cur.children[index];
        }
        cur.isEnd = true;
    }
}
