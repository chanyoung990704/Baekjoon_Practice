import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::valueOf).toArray();

        int M = Integer.valueOf(br.readLine());
        int[] B = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::valueOf).toArray();        

        List<Integer> result = new ArrayList<>();
        
        int aIdx = 0;
        int bIdx = 0;

        while (aIdx < N && bIdx < M) {
            int max = -1;
            int aIdxNext = -1;
            int bIdxNext = -1;

            // 현재부터 이후 가장 큰 값 찾기
            for(int i = aIdx ; i < N ; i++){
                if(A[i] <= max){
                    continue;
                }
                for(int j = bIdx ; j < M ; j++){
                    if(A[i] == B[j] && B[j] > max){
                        max = B[j];
                        aIdxNext = i;
                        bIdxNext = j;
                    }
                }
            }

            if(max == -1){
                break;
            }

            aIdx = aIdxNext + 1;
            bIdx = bIdxNext + 1;
            result.add(max);
        }
        
 
        if(result.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(result.size());
            System.out.println(
                result.stream().map(String::valueOf).collect(Collectors.joining(" "))
            );
        }
    }
}
