import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 기존 코드 유지 (입력 및 날짜 처리 부분)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int N = Integer.valueOf(br.readLine());

        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            list.add(Integer.valueOf(br.readLine()));
        }

        // 정렬 
        list.sort(Comparator.naturalOrder());

        int total = -1;
        for(int i = list.size() - 1 ; i >= 2 ; i--){
            int a = list.get(i);
            int b = list.get(i - 1);
            int c = list.get(i - 2);

            if(a < b + c){
                total = a + b + c;
                break;
            }
        }
        
        System.out.println(total);
    }
}
