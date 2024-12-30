import java.io.*;
import java.util.*;
import java.util.stream.*;

import javax.xml.crypto.Data;

import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            int cnt = Integer.valueOf(br.readLine());
            list.add(cnt);
        }

        if(N == 1){
            System.out.println(0);
            return;
        }
        
        List<Integer> sub = list.subList(1, list.size());

        int cnt = 0;
        while (list.get(0) <= Collections.max(sub)) {
            list.set(0, list.get(0) + 1);
            for(int i = 0 ; i < sub.size() ; i++)
                if(sub.get(i) == Collections.max(sub)){
                    sub.set(i, sub.get(i) - 1);
                    break;
                }
            cnt++;
        }


        System.out.println(cnt);

        br.close();


    }
}