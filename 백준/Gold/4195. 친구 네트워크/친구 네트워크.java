import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static Map<String, String> parents;
    static Map<String, Integer> groups;

    static String findParent(String s){
        if(parents.get(s).equals(s)){
            return parents.get(s);
        }

        parents.put(s, findParent(parents.get(s)));
        return parents.get(s);
    }

    static void unionParent(String a, String b){
        String aParent = findParent(a);
        String bParent = findParent(b);

        if(aParent.compareTo(bParent) <= 0){
            parents.put(bParent, aParent);
        }else{
            parents.put(aParent, bParent);
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            parents = new HashMap<>();
            groups = new HashMap<>();

            for(int i = 0; i < N; i++){
                String[] s  = br.readLine().split(" ");
                String a = s[0];
                String b = s[1];

                // 초기화
                if(!parents.containsKey(a)){
                    parents.put(a, a);
                }
                if(!parents.containsKey(b)){
                    parents.put(b, b);
                }

                if(findParent(a).equals(findParent(b))){
                    System.out.println(groups.get(findParent(a)));
                }else{
                    // 현재 각 그룹에 몇명있는지 확인
                    Integer a1 = groups.getOrDefault(findParent(a), 1);
                    Integer b1 = groups.getOrDefault(findParent(b), 1);

                    if(groups.containsKey(findParent(a))){
                        groups.remove(findParent(a));
                    }
                    if(groups.containsKey(findParent(b))){
                        groups.remove(findParent(b));
                    }

                    // 합치기
                    unionParent(a, b);

                    // 갱신
                    groups.put(findParent(a), b1 + a1);

                    System.out.println(groups.get(findParent(a)));
                }

            }

        }
    }
}
