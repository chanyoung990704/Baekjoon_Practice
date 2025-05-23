import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
import java.util.stream.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int Q = sc.nextInt();
            
            List<int[]> queries = new ArrayList<>();
            for(int i = 0; i < Q; i++){
                queries.add(new int[]{sc.nextInt(), sc.nextInt()});   
            }
            
            int[] result = new int[N+1];
            boolean[] processed = new boolean[N+1];
            
            // 역순으로 처리
            for(int i = Q-1; i >= 0; i--){
                int[] current = queries.get(i);
                for(int j = current[0]; j <= current[1]; j++){
                    if(!processed[j]){
                        result[j] = i + 1;
                        processed[j] = true;
                    }
                }
            }
            
            int[] output = Arrays.copyOfRange(result, 1, result.length);
            String res = Arrays.stream(output)
                              .mapToObj(String::valueOf)
                              .collect(Collectors.joining(" "));
            System.out.println("#" + test_case + " " + res);
        }
    }
}
