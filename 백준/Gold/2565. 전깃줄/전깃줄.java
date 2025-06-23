import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            list.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        list.sort((a,b) -> a[0] - b[0]);

        int[] right = new int[N];
        for(int i = 0 ; i < N ; i++){
            right[i] = list.get(i)[1];
        }

        // LIS
        int[] lis =  new int[N];
        Arrays.fill(lis,1);

        for(int i = 1 ; i < N ; i++){
            for(int j = 0 ; j < i ; j++){
                if(right[i] > right[j]){
                    lis[i] = Math.max(lis[i],lis[j] + 1);
                }
            }
        }

        System.out.println(N - Arrays.stream(lis).max().getAsInt());
    }
}
