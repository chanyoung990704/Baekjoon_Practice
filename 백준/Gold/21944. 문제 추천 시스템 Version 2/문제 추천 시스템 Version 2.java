
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Problem{
        int p;
        int l;
        int g;

        public Problem(int p, int l, int g) {
            this.p = p;
            this.l = l;
            this.g = g;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문제 개수 N
        int N = Integer.valueOf(br.readLine());

        // 문제 번호 P 난이도 L 알고리즘 분류 G
        List<Problem> problems = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            problems.add(new Problem(input[0], input[1], input[2]));
        }

        // 알고리즘 분류별 문제 맵핑
        TreeMap<Integer, TreeSet<Problem>> map = new TreeMap<>();
        // 문제 번호로 빠르게 찾기 위한 맵
        HashMap<Integer, Problem> problemMap = new HashMap<>();
        
        for (Problem p : problems) {
            map.computeIfAbsent(p.g, k -> new TreeSet<>(Comparator.comparing((Problem pb) -> pb.l).thenComparing((Problem pb) -> pb.p))).add(p);
            problemMap.put(p.p, p);
        }

        // 난이도별 정렬된 문제 트리셋 (recommend3용)
        TreeSet<Problem> byLevel = new TreeSet<>(Comparator.comparing((Problem p) -> p.l).thenComparing(p -> p.p));
        byLevel.addAll(problems);

        // 명령어
        int M = Integer.valueOf(br.readLine());
        for(int i = 0; i < M; i++){
            String[] input = br.readLine().split(" ");
            String op = input[0];

            switch(op){
                case "recommend":
                    recommend(Integer.valueOf(input[1]), Integer.valueOf(input[2]), map);
                    break;
                case "recommend2":
                    recommend2(Integer.valueOf(input[1]), map);
                    break;
                case "recommend3":
                    recommend3(Integer.valueOf(input[1]), Integer.valueOf(input[2]), byLevel);
                    break;
                case "add":
                    pAdd(Integer.valueOf(input[1]), Integer.valueOf(input[2]), Integer.valueOf(input[3]), map, problemMap, byLevel);
                    break;
                case "solved":
                    solved(Integer.valueOf(input[1]), map, problemMap, byLevel);
                    break;
                default:
                    break;
            }
        }
    }

    private static void solved(Integer p, TreeMap<Integer, TreeSet<Problem>> map, HashMap<Integer, Problem> problemMap, TreeSet<Problem> byLevel) {
        Problem problem = problemMap.get(p);
        if (problem != null) {
            map.get(problem.g).remove(problem);
            if(map.get(problem.g).isEmpty()){
                map.remove(problem.g);
            }
            byLevel.remove(problem);
            problemMap.remove(p);
        }
    }

    private static void pAdd(Integer p, Integer l, Integer g, TreeMap<Integer, TreeSet<Problem>> map, HashMap<Integer, Problem> problemMap, TreeSet<Problem> byLevel) {
        Problem problem = new Problem(p, l, g);
        map.computeIfAbsent(g, k -> new TreeSet<>(Comparator.comparing((Problem pb) -> pb.l).thenComparing((Problem pb) -> pb.p))).add(problem);
        problemMap.put(p, problem);
        byLevel.add(problem);
    }

    private static void recommend3(Integer x, Integer l, TreeSet<Problem> byLevel) {
        if (x == 1) {
            // 난이도 L 이상인 가장 쉬운 문제
            Problem ceiling = byLevel.ceiling(new Problem(0, l, 0));
            if (ceiling != null) {
                System.out.println(ceiling.p);
            } else {
                System.out.println(-1);
            }
        } else if (x == -1) {
            // 난이도 L 미만인 가장 어려운 문제
            Problem floor = byLevel.floor(new Problem(Integer.MAX_VALUE, l-1, 0));
            if (floor != null) {
                System.out.println(floor.p);
            } else {
                System.out.println(-1);
            }
        }
    }

    private static void recommend2(Integer x, TreeMap<Integer, TreeSet<Problem>> map) {
        // 1 가장 어려움
        if(x == 1){
            int max = 0;
            int maxp = -1;

            for(Map.Entry<Integer, TreeSet<Problem>> entry : map.entrySet()){
                Problem last = entry.getValue().last();
                if(last.l > max){
                    max = last.l;
                    maxp = last.p;
                }else if(last.l == max && last.p > maxp){
                    maxp = last.p;
                }
            }

            System.out.println(maxp);
        }

        // -1 가장 쉬움
        if(x == -1){
            int min = Integer.MAX_VALUE;
            int minp = Integer.MAX_VALUE;

            for(Map.Entry<Integer, TreeSet<Problem>> entry : map.entrySet()){
                Problem first = entry.getValue().first();
                if(first.l < min){
                    min = first.l;
                    minp = first.p;
                }else if(first.l == min && first.p < minp){
                    minp = first.p;
                }
            }
            System.out.println(minp);
        }
    }

    private static void recommend(Integer g, Integer x, TreeMap<Integer, TreeSet<Problem>> map) {
        // 1 어려우면서 큼
        if(x == 1){
            Problem last = map.get(g).last();
            System.out.println(last.p);
        }
        // -1 쉬우면서 작음
        if (x == -1) {
            Problem first = map.get(g).first();
            System.out.println(first.p);
        }
    }
}
