import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] NM = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::valueOf)
        .toArray();

        List<List<Integer>> idxs = new ArrayList<>();
        for(int i = 0 ; i < NM[0] ; i++){
            List<Integer> list = Arrays.stream(br.readLine().split(" "))
            .map(cur -> Integer.valueOf(cur))
            .collect(Collectors.toList());
            idxs.add(list);
        }

        List<List<Integer>> chickens = new ArrayList<>();
        List<List<Integer>> houses = new ArrayList<>();
        for(int i = 0 ; i < NM[0] ; i++){
            for(int j = 0 ; j < NM[0] ; j++){
                if(idxs.get(i).get(j) == 1) houses.add(List.of(i, j));
                else if(idxs.get(i).get(j) == 2) chickens.add(List.of(i, j));
            }
        }
        combination(houses, chickens, 0, NM[1], new ArrayList<>());

        System.out.println(res);

        br.close();
    }

    static void combination(List<List<Integer>> houses, List<List<Integer>> chickens, int idx, int size, List<List<Integer>> result){
        if(result.size() == size){
            int curCost = getDist(houses, result);
            res = Math.min(res, curCost);
            return;
        }

        for(int i = idx ; i < chickens.size() ; i++){
            result.add(chickens.get(i));
            combination(houses, chickens, i + 1, size, result);
            result.remove(result.size() - 1);
        }
    }

    static int getDist(List<List<Integer>> houses, List<List<Integer>> result){
        int total = 0;
        for(List<Integer> house : houses){
            int dist = Integer.MAX_VALUE;
            for(List<Integer> r : result) dist = Math.min(dist, Math.abs(house.get(0) - r.get(0)) + Math.abs(house.get(1) - r.get(1)));
            total += dist;
        }
        return total;
    }
}