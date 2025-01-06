import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> AB = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        if(AB.get(0).compareTo(AB.get(1)) < 0){
            System.out.println("<");
        }else if(AB.get(0).compareTo(AB.get(1)) == 0){
            System.out.println("==");
        }else{
            System.out.println(">");
        }

    }
}
