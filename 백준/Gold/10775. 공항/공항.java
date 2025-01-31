import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int G = Integer.valueOf(br.readLine());
        int P = Integer.valueOf(br.readLine());

        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < P ; i++){
            list.add(Integer.valueOf(br.readLine()));
        }

        int[] parent = new int[G + 1];
        for(int i = 0 ; i <= G ; i++){
            parent[i] = i;
        }

        // 0으로 도달하면 도킹 불가
        // 가장 높은 번호부터 낮은 번호 순으로 도킹
        int cnt = 0;
        for(int cur : list){
            // 도킹 가능한 번호 찾기
            int idx = findParent(parent, cur);

            // 불가능
            if(idx == 0){
                break;
            }

            // 도킹 가능하면 경로 압축 사용해서 경로 저장
            parent[idx] = idx - 1;
            cnt++;
        }

        System.out.println(cnt);
    }

    static int findParent(int[] parent, int cur){
        if(parent[cur] != cur){
            parent[cur] = findParent(parent, parent[cur]);
        }
        return parent[cur];
    }
}
