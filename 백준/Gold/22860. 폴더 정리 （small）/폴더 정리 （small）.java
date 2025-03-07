
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {

    static class Node{
        String name;
        int folder;
        List<Node> children = new ArrayList<>();

        public Node(String name, int folder) {
            this.name = name;
            this.folder = folder;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NM[0];
        int M = NM[1];

        // 폴더 계층 입력
        Map<String, Node> folderMap  = new HashMap<>();
        Node main = new Node("main", 1);
        folderMap.put("main", main);

        String[] input = new String[N + M];
        for(int i = 0 ; i < N + M ; i++){
            input[i] = br.readLine();
            // 폴더는 미리 초기화
            String[] cur = input[i].split(" ");
            String p = cur[0];
            String c = cur[1];
            int f = Integer.valueOf(cur[2]);

            if(f == 1){
                folderMap.put(c, new Node(c, 1));
            }
        }

        // 트리 구조
        for(int i = 0 ; i < N + M ; i++){
            String[] cur = input[i].split(" ");
            String p = cur[0];
            String c = cur[1];
            int f = Integer.valueOf(cur[2]);

            // 계층 찾기
            Node parent = folderMap.get(p);
            Node child;
            if(f == 1 && folderMap.containsKey(c)){
                child = folderMap.get(c);
            }else{
                child = new Node(c, f);
            }

            // 연결
            parent.children.add(child);
        }

        // 쿼리입력
        int q = Integer.valueOf(br.readLine());
        for(int i = 0 ; i < q ; i++){
            String[] cur = br.readLine().split("/");
            Node folder = folderMap.get(cur[cur.length - 1]);

            // 폴더 파일 개수 탐색
            Set<String> files = new HashSet<>();
            int[] cnt = new int[1];

            dfs(folder, files, cnt);

            System.out.println(files.size() + " " + cnt[0]);
        }
    }

    private static void dfs(Node folder, Set<String> files, int[] cnt) {
        for(Node child : folder.children){
            // 폴더면 탐색
            if(child.folder == 1){
                dfs(child, files, cnt);
            }else{
                files.add(child.name);
                cnt[0]++;
            }
        }
    }

}
