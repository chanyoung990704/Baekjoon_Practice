import java.util.*;
import java.util.stream.*;
import java.util.regex.*;
import java.io.*;

public class Main {

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NM = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NM.get(0);
        int M = NM.get(1);

        List<List<Integer>> city = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            city.add(Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList()));
        }

        List<int[]> houses = new ArrayList<>();
        List<int[]> chickens = new ArrayList<>();

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(city.get(i).get(j) == 1){
                    houses.add(new int[]{i, j});
                }
                if(city.get(i).get(j) == 2){
                    chickens.add(new int[]{i, j});
                }
            }
        }

        comb(houses, chickens, new ArrayList<>(), 0, M);

        System.out.println(min);

    }

    static void comb(List<int[]> houses, List<int[]> chickens, List<int[]> res, int idx, int M){
        if(res.size() == M){
            calDistance(houses, res);
        }

        int len = chickens.size();
        for(int i = idx ; i < len ; i++){
            int[] cur = chickens.get(i);
            res.add(cur);
            comb(houses, chickens, res, i + 1, M);
            res.remove(res.size() - 1);
        }
    }

    static void calDistance(List<int[]> houses, List<int[]> res){
        int total = 0;
        for(int i = 0 ; i < houses.size() ; i++){
            int[] house = houses.get(i);
            int houseDist = Integer.MAX_VALUE;
            for(int j = 0 ; j < res.size() ; j++){
                int[] chicken = res.get(j);
                int dist = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                if(dist < houseDist){
                    houseDist = dist;
                }
            }
            total += houseDist;
        }

        if(total < min){
            min = total;
        }
    }
}
