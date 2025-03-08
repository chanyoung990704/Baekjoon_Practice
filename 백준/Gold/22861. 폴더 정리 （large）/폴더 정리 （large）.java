
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {

    static class Node {
        String name;
        int folder;
        Map<String, Node> children = new HashMap<>();

        public Node(String name, int folder) {
            this.name = name;
            this.folder = folder;
        }

        void removeChild(String folderName) {
            Node child = children.get(folderName);
            if (child != null && child.folder == 1) {
                children.remove(folderName);
            }
        }

        boolean findSameNameFile(String fileName) {
            Node child = children.get(fileName);
            return child != null && child.folder == 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = NM[0];
        int M = NM[1];

        // 폴더 계층 입력
        String[] inputs = new String[N + M];
        Map<String, Node> map = new HashMap<>();
        map.put("main", new Node("main", 1));

        for(int i = 0 ; i < inputs.length ; i++) {
            inputs[i] = br.readLine();

            String[] str = inputs[i].split(" ");
            // 폴더라면
            if(str[2].equals("1")){
                map.put(str[1], new Node(str[1], 1));
            }
        }

        // 폴더 그래프
        for(int i = 0 ; i < inputs.length ; i++) {
            String[] str = inputs[i].split(" ");
            String f = str[0];
            String t = str[1];
            int isFolder = Integer.valueOf(str[2]);

            Node node = null;
            // 폴더면 맵에서 가져옴
            if(isFolder == 1){
                node = map.get(t);
            }else{
                node = new Node(t, isFolder);
            }

            // 그래프 연결
            map.get(f).children.put(node.name, node);
        }



        int op = Integer.valueOf(br.readLine());
        for (int i = 0; i < op; i++) {
            String[] input = br.readLine().split(" ");

            // 부모 찾아서 연결 끊고
            String[] from = input[0].split("/");
            Node f = map.get(from[from.length - 1]);
            Node parent = map.get(from[from.length - 2]);

            parent.removeChild(f.name);
            // 새 부모 찾아서 연결
            String[] to = input[1].split("/");
            Node t = map.get(to[to.length - 1]);
            for (Node child : f.children.values()) {
                if (child.folder == 0 && t.findSameNameFile(child.name)) {
                    continue;
                }
                t.children.put(child.name, child);
            }
            // 폴더 삭제
            map.remove(f.name);
        }

        int q = Integer.valueOf(br.readLine());
        for (int i = 0; i < q; i++) {
            String[] input = br.readLine().split("/");
            Node node = map.get(input[input.length - 1]);

            Set<String> files = new HashSet<>();
            int[] cnt = new int[1];

            dfs(node, files, cnt);

            System.out.println(files.size() + " " + cnt[0]);
        }
    }

    private static void dfs(Node node, Set<String> files, int[] cnt) {
        for(Node child : node.children.values()) {
            if (child.folder == 1) {
                dfs(child, files, cnt);
            } else {
                cnt[0]++;
                files.add(child.name);
            }
        }
    }

}
