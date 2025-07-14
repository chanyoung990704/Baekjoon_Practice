import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        int[] prev = new int[N];
        Arrays.fill(prev, -1);

        int[] lis = new int[N];
        lis[0] = list.get(0);

        int size=  1;

        for(int i = 1; i < N; i++) {
            int cur = list.get(i);
            if(lis[size-1] < cur){
                lis[size] = cur;
                prev[i] = size-1;
                size++;
            }else{
                int lo = 0;
                int hi = size - 1;
                while(lo < hi){
                    int mid = lo + (hi-lo)/2;
                    if(lis[mid] < cur){
                        lo = mid+1;
                    }else{
                        hi = mid;
                    }
                }

                lis[lo] = cur;
                prev[i] = lo-1;
            }
        }



        List<Integer> ans = new ArrayList<>();
        int idx = size - 2;

        for(int i = N-1; i >= 0; i--){
            if(prev[i] == idx){
                ans.add(list.get(i));
                idx--;
            }
        }

        Collections.reverse(ans);

        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append("\n");
        for(int i = 0; i < ans.size(); i++){
            sb.append(ans.get(i)).append(" ");
        }
        System.out.println(sb);

    }
}
