import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        
        List<Integer> button = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        List<Integer> init = new ArrayList<>(Collections.nCopies(n, 0));

        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            // 다르면 변경
            if(init.get(i) != button.get(i)){
                for(int j = i ; j < Math.min(n, i + 3) ; j++)
                    init.set(j, changeButton(init.get(j)));
                cnt++;
            }
        }
 
        System.out.println(cnt);
    }

    static int changeButton(int i){
        if(i == 0) return 1;
        else return 0;
    }
}
