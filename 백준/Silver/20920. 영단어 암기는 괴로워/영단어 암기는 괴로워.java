import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.regex.*;

public class Main {

    static class Word{
        String name;
        int cnt;
        int len;

        Word(String name, int cnt, int len){
            this.name = name;
            this.cnt = cnt;
            this.len = len;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new TreeMap<>();
        
        List<Integer> NM = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NM.get(0);
        int M = NM.get(1);

        for(int i = 0 ; i < N ; i++){
            String cur = br.readLine();
            if(cur.length() < M){
                continue;
            }
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }

        List<Word> list = map.entrySet().stream()
        .map(i -> new Word(i.getKey(), i.getValue(), i.getKey().length()))
        .sorted(Comparator.comparing((Word w) -> w.cnt).reversed()
        .thenComparing(Comparator.comparing((Word w) -> w.len).reversed())
        .thenComparing((Word w) -> w.name))
        .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for(Word word : list){
            sb.append(word.name + "\n");
        }

        System.out.println(sb.toString());
    }
}
