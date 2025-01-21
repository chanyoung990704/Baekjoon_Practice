import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.regex.*;

public class Main {

    static class Book{
        String name;
        int cnt;

        Book(String name, int cnt){
            this.name = name;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new TreeMap<>();
        int N = Integer.valueOf(br.readLine());

        for(int i = 0 ; i < N ; i++){
            String cur = br.readLine();
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }

        List<Book> list = map.entrySet().stream()
        .map(i -> new Book(i.getKey(), i.getValue()))
        .sorted(Comparator.comparing((Book b) -> b.cnt).reversed()
        .thenComparing((Book b) -> b.name))
        .collect(Collectors.toList());

        System.out.println(list.get(0).name);
    }
}
