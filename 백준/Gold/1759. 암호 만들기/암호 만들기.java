import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int L;
    static int C;
    static String[] words;
    static Set<Character> l = Set.of('a', 'e', 'i', 'o', 'u'); // 모음 저장
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] LC = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::valueOf)
        .toArray();
        L = LC[0];  C = LC[1];

        words = Arrays.stream(br.readLine().split(" "))
        .sorted()
        .toArray(String[]::new); 

        getComb(0, "");
        
        br.close();
    }

    public static void getComb(int idx, String ret){
        if(ret.length() == L){
            int lCnt = 0; // 모음 개수
            for(int i = 0 ; i < ret.length() ; i++) {
                if(l.contains(ret.charAt(i))) lCnt++; 
            }
            if(lCnt >= 1 && ret.length() - lCnt >= 2) System.out.println(ret);
            return;
        }

        for(int i = idx ; i < C ; i++) getComb(i + 1, ret + words[i]); 
    }
}