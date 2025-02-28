import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    static int ret = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        List<Integer> NK = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NK.get(0);
        int K = NK.get(1);

        List<String> words = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            words.add(br.readLine());
        }

        List<Set<Integer>> listSet = 
        words.stream().map(i -> i.chars()
        .boxed().collect(Collectors.toSet()))
        .collect(Collectors.toList());

        // 초기화
        boolean[] alphabets = new boolean[26];
        alphabets['a' - 'a'] = true;
        alphabets['n' - 'a'] = true;
        alphabets['t' - 'a'] = true;
        alphabets['i' - 'a'] = true;
        alphabets['c' - 'a'] = true;

        // 기초 단어도 못 읽는 경우
        if(K < 5){
            System.out.println(0);
            return;
        }

        combination(K - 5, alphabets,  0, listSet);
        
        System.out.println(ret);
    }

    static void combination(int cnt, boolean[] alphabets, int cur, List<Set<Integer>> listSet){
        if(cnt == 0){
            // 개수 확인
            Set<Integer> knows = IntStream.range(0, 26)
            .filter(i -> alphabets[i]).mapToObj(i -> Integer.valueOf(i + 'a'))
            .collect(Collectors.toSet());

            int curCnt = 0;
            for(Set<Integer> s : listSet){
                boolean readable = true;
                for(int i : s){
                    // 모르는 단어
                    if(!knows.contains(i)){
                        readable = false;
                        break;
                    }
                }
                if(readable){
                    curCnt++;
                }
            }

            ret = Math.max(ret, curCnt);
            return;
        }

        for(int i = cur ; i < 26 ; i++){
            if(alphabets[i] == false){
                alphabets[i] = true;
                combination(cnt - 1, alphabets, i + 1, listSet);
                alphabets[i] = false;
            }
        }
    }
}


