

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.valueOf(br.readLine());

        while (t-- > 0) {
            int n  = Integer.valueOf(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                String[] op = br.readLine().split(" ");
                if (op[0].equals("I")) {
                    int v = Integer.valueOf(op[1]);
                    map.put(v, map.getOrDefault(v, 0) + 1);
                }else if(op[0].equals("D")){
                    int r = Integer.valueOf(op[1]);
                    if(map.size() == 0){
                        continue;
                    }
                    if (r == 1) {
                        int k = map.lastKey();
                        map.put(k, map.get(k) - 1);
                        if(map.get(k) == 0){
                            map.remove(k);
                        }
                    } else if (r == -1) {
                        int k = map.firstKey();
                        map.put(k, map.get(k) - 1);
                        if(map.get(k) == 0){
                            map.remove(k);
                        }
                    }
                }
            }

            if(map.size() == 0){
                System.out.println("EMPTY");
            }else{
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }

    }
}
