import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        permutation(list, new boolean[11], new ArrayList<>());

        System.out.println(
            ans.stream().map(String::valueOf).collect(Collectors.joining(" "))
        );
    }


    static void permutation(List<Integer> list, boolean[] visited, List<Integer> res){

        if(res.size() == list.size()){
            int[] cnt = new int[list.size()];
            for(int i = 0 ; i < res.size() ; i++){
                int cur = res.get(i);
                int bigMan = 0;
                for(int j = i - 1 ; j >= 0 ; j--)
                    if(res.get(j) > cur) bigMan++;
                cnt[cur - 1] = bigMan;
            }

            for(int i = 0 ; i < list.size() ; i++){
                if(list.get(i) != cnt[i]) return;
            }
            ans = new ArrayList<>(res);
            return;
        }

        for(int i = 1 ; i <= list.size() ; i++){
            if(!visited[i]){
                visited[i] = true;
                res.add(i);
                permutation(list, visited, res);
                res.remove(res.size() - 1);
                visited[i] = false;
            }
        }
    }
}