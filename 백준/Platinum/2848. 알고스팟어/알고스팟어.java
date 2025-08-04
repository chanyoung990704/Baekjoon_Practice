import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] str =new String[N];
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
            for(char c : str[i].toCharArray()) {
                set.add(c);
            }
        }

        Map<Character, List<Character>> outDegree = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for (int i = 0; i < N - 1; i++) {
            String str1 = str[i];
            String str2 = str[i + 1];

            boolean foundDiff = false;
            for(int j = 0 ; j < Math.min(str1.length(), str2.length()); j++) {
                if(str1.charAt(j) != str2.charAt(j)) {
                    inDegree.put(str2.charAt(j), inDegree.getOrDefault(str2.charAt(j), 0) + 1);
                    outDegree.computeIfAbsent(str1.charAt(j), k -> new ArrayList<>()).add(str2.charAt(j));
                    foundDiff = true;
                    break;
                }
            }

            // 접두사 관계 문제 처리
            if (!foundDiff && str1.length() > str2.length()) {
                System.out.println("!");
                return;
            }
        }


        // 진입차수 0인거
        Queue<Character> q = new LinkedList<>();
        for(char c : set) {
            if(!inDegree.containsKey(c)) {
                q.add(c);
            }
        }

        List<Character> res = new ArrayList<>();
        boolean flag = false;

        while(!q.isEmpty()) {
            // q사이즈 2개 이상
            if(q.size() > 1){
                flag = true;
            }

            Character c = q.poll();
            res.add(c);

            for(Character next : outDegree.getOrDefault(c, Collections.emptyList())) {
                inDegree.put(next, inDegree.get(next) - 1);
                if(inDegree.get(next) == 0) {
                    q.offer(next);
                }
            }

        }

        if(res.size() != set.size()) {
            System.out.println("!");
            return;
        } else if (flag) {
            System.out.println("?");
            return;
        }

        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining()));

    }
}
