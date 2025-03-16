

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {

    static List<int[]> pairIdx = new ArrayList<>(); // 괄호 인덱스
    static Set<String> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        // 괄호 인덱스 찾기
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0 ; i < str.length() ; i++) {
            char cur = str.charAt(i);
            if (cur == '(') {
                dq.offerLast(i);
            }else if(cur == ')'){
                pairIdx.add(new int[]{dq.pollLast(), i});
            }
        }
        
        // 괄호 개수만큼 조합
        combination(str, 0, new boolean[pairIdx.size()], 0);

        for (String s : set) {
            System.out.println(s);
        }
    }

    private static void combination(String str, int cur, boolean[] visited, int cnt) {
        // 조합
        // visited가 true이면 그것을 사용하지 않음
        if (cnt > 0) {
            // 인덱스 제외 String만들기
            StringBuilder sb = new StringBuilder();
            Set<Integer> idxSet = new HashSet<>();
            for(int i = 0 ; i < visited.length ; i++) {
                if(!visited[i]){
                    int[] p = pairIdx.get(i);
                    idxSet.add(p[0]);
                    idxSet.add(p[1]);
                }
            }

            for(int i = 0 ; i < str.length() ; i++) {
                char c = str.charAt(i);

                if (c == '(' || c == ')') {
                    if(idxSet.contains(i)){
                        sb.append(c);
                    }
                }else{
                    sb.append(c);
                }
            }

            set.add(sb.toString());
        }

        for(int i = cur ; i < pairIdx.size() ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination(str, i + 1, visited, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
