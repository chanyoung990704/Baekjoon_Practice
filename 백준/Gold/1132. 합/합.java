import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int N = Integer.valueOf(br.readLine());

        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            list.add(br.readLine());
        }

        // map에 알파벳 가중치
        Map<Character, Long> map = new HashMap<>();
        Map<Character, Boolean> isFirst = new HashMap<>();
        for(String cur : list){
            long val = (long)Math.pow(10, cur.length() - 1);
            for(int i = 0 ; i < cur.length() ; i++){
                char c = cur.charAt(i);
                if(i == 0 && !isFirst.containsKey(c)){
                    isFirst.put(c, true);
                }
                map.put(c, map.getOrDefault(c, 0L) + val);
                val /= 10;
            }
        }
        // 내림차순 정렬
        map = map.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
            (o, n) -> o, LinkedHashMap::new
        ));

        // 시작 위치에 나오지 않았고 가장 낮은 가중치를 갖는 값 찾기
        char[] arr = new char[]{'A','B','C','D','E','F','G','H','I','J'};
        Character zero = null;
        long weight = Long.MAX_VALUE;
        for(char c : arr){
            // 나오지 않은 값
            if(!map.containsKey(c)){
                zero = c;
                break;
            }
            long curVal = map.get(c);
            if(!isFirst.containsKey(c) && weight > curVal){
                zero = c;
                weight = curVal;
            }
        }

        Map<Character, Integer> alphabet = new HashMap<>();
        int digit = 9;
        for(Map.Entry<Character, Long> e : map.entrySet()){
            char k = e.getKey();
            if(k == zero){
                alphabet.put(k, 0);
                continue;
            }
            alphabet.put(k, digit);
            digit--;
        }

       // 총합 계산
       long total = 0;
       StringBuilder sb = new StringBuilder();
       for(String str : list){
        sb.setLength(0);
        for(int i = 0 ; i < str.length() ; i++){
            sb.append(alphabet.get(str.charAt(i)));
        }
        total += Long.valueOf(sb.toString());
       }

       System.out.println(total);
    }
}

