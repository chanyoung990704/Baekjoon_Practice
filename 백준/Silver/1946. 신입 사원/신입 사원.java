import java.util.*;
import java.util.stream.*;
import java.util.regex.*;
import java.io.*;

public class Main {
    static class Person{
        int first;
        int second;

        Person(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());

        while (T > 0) {
            T--;

            int N = Integer.valueOf(br.readLine());
            List<Person> list = new ArrayList<>();
            for(int i = 0 ; i < N ; i++){
                List<Integer> cur = Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList());
                list.add(new Person(cur.get(0), cur.get(1)));
            }


            list.sort(Comparator.comparing((Person p) -> p.first));
            int cnt = 1;
            int max = list.get(0).second;

            for(int i = 1; i < list.size() ; i++){
                if(list.get(i).second < max){
                    cnt++;
                    max = list.get(i).second;
                }
            }

            System.out.println(cnt);

        }


    }


}
