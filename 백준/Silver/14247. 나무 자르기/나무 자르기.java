import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {    
    static class Tree {
    
        int today;
        int rate;

        Tree(int today, int rate){
            this.today = today;
            this.rate = rate;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        
        List<Integer> today = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        List<Integer> rate = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList()); 
        
        List<Tree> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) list.add(new Tree(today.get(i), rate.get(i)));

        list.sort(Comparator.comparing((Tree t) -> t.rate));

        long total = 0;
        for(int i = 0 ; i < n ; i++){
            total += list.get(i).today + (list.get(i).rate * i);
        }

        System.out.println(total);
    }
}
